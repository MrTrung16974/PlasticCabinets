package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.exception.ResurceNotFoundException;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductApiController {
    @Autowired
    ProductsRepository productsRepository;

//    Get all Product
    @GetMapping("/products")
    public List<Products> getAllProduct() {
        return productsRepository.findAll();
    }

// Create a product
    @PostMapping("/product")
    public Products createProduct(@Valid @RequestBody Products product) {
        return productsRepository.save(product);
    }

//    Get a single product
    @GetMapping("/product/{id}")
    public Products getProductById(@PathVariable(value = "id") Integer productId) {
        return productsRepository.findById(productId).orElseThrow(() -> new ResurceNotFoundException("Product", "id", productId));
    }

//    update a product
    @PutMapping("/product/{id}")
    public Products updateProduct(@Valid @PathVariable(value = "id") Integer productId, @Valid @RequestBody Products productDetail) {
        Products product = productsRepository.findById(productId).orElseThrow(() -> new ResurceNotFoundException("Product", "id", productId));
        product.setName(productDetail.getName());
        product.setImgProduct(productDetail.getImgProduct());
        product.setNewPrice(productDetail.getNewPrice());
        product.setOldPrice(productDetail.getOldPrice());
        product.setPromotional(productDetail.getPromotional());
        product.setStar(productDetail.getStar());
        Products updateProduct = productsRepository.save(product);
        return updateProduct;
    }

//    Delete a product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer productId) {
        Products product = productsRepository.findById(productId).orElseThrow(() ->
                new ResurceNotFoundException("Product", "id", productId));
        productsRepository.delete(product);
        return ResponseEntity.ok().build();
    }

}
