package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductApiController productApiController;

    @RequestMapping("/home")
    public String home(){
        return "admin/index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        String fileName = "";
        String fileLink = "http://localhost:8080/link/";
        try {
            if(file.isEmpty()) {
                throw new Exception();
            }
            fileName = storeFileService.store(file);
            fileLink += fileName;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return fileLink;
    }

    @PostMapping(value = "/product")
    @ResponseBody
    public int createProduct(Model model, @Valid @RequestParam Products products) {
        if(products.getName() != null && products.getDescription() != null) {
            products.setCreateBy(1);
            productApiController.createProduct(products);
        }else {
            return 1;
        }
        return 0;

    }

}
