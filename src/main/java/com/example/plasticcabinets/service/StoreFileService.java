package com.example.plasticcabinets.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

@Service
public class StoreFileService {
    @Value("./upload")
    private Path rootLocation;

    public String store(MultipartFile file) {
        long unixTimetamp = Instant.now().getEpochSecond();
        String newFileName = "";
        try {
            newFileName = "" + unixTimetamp + "-" + file.getOriginalFilename();
            Files.copy(file.getInputStream(),this.rootLocation.resolve(newFileName));
        }catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return newFileName;
    }

    public Resource loadFile(String fileName) {
        try{
            Path file = rootLocation.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                System.out.println(resource.exists());
                System.out.println(resource.isReadable());
                return resource;
            }else{
                throw new RuntimeException("FAIL!");
            }
        }catch (MalformedURLException e) {
            throw  new RuntimeException("FAIL!");
        }
    }
}
