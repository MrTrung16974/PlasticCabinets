package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.CastProduct;
import com.example.plasticcabinets.model.ImageProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.repository.CastProductRepository;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MockData {
    protected List<Products> allProduct = new ArrayList<>();
    protected List<Products> allGoodProduct = new ArrayList<>();
    protected List<Users> allUser = new ArrayList<>();
    protected List<ImageProduct> allImageProduct = new ArrayList<>();
    protected List<CastProduct> allCastProduct = new ArrayList<>();
    protected Set<CastProduct> lstCastProduct = new HashSet<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    CastProductRepository castProductRepository;

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductApiController productApiController;

    @PostConstruct
    public void mockData() {
        allProduct = productsRepository.findAll();
        allCastProduct = castProductRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        allUser = userRepository.findAll();
        allGoodProduct = productsRepository.goodProduct(4);
        for(CastProduct cast : allCastProduct) {
            if(cast.getCreateBy() == 1) {
                lstCastProduct.add(cast);
            }
        }

    }

    public List<Products> getAllProduct() {
        return allProduct;
    }

    public void setAllProduct(List<Products> allProduct) {
        this.allProduct = allProduct;
    }

    public List<Products> getAllGoodProduct() {
        return allGoodProduct;
    }

    public void setAllGoodProduct(List<Products> allGoodProduct) {
        this.allGoodProduct = allGoodProduct;
    }

    public List<Users> getAllUser() {
        return allUser;
    }

    public void setAllUser(List<Users> allUser) {
        this.allUser = allUser;
    }

    public List<ImageProduct> getAllImageProduct() {
        return allImageProduct;
    }

    public void setAllImageProduct(List<ImageProduct> allImageProduct) {
        this.allImageProduct = allImageProduct;
    }

    public List<CastProduct> getAllCastProduct() {
        return allCastProduct;
    }

    public void setAllCastProduct(List<CastProduct> allCastProduct) {
        this.allCastProduct = allCastProduct;
    }

    public Set<CastProduct> getLstCastProduct() {
        return lstCastProduct;
    }

    public void setLstCastProduct(Set<CastProduct> lstCastProduct) {
        this.lstCastProduct = lstCastProduct;
    }
}
