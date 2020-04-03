package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.ImageProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class LogicControler {

    private List<Products> allProduct = new ArrayList<>();
    private List<ImageProduct> allImageProduct = new ArrayList<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductApiController productApiController;

    @GetMapping("/edit/{id}/detail")
    public String edit(@PathVariable("id") Integer idProduct, Model model) {
        allProduct = productsRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        Products product = null;
        for (Products p : allProduct) {
            if(p.getId() == idProduct) {
                product = p;
            }
        }
        model.addAttribute("product", product);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/editProduct";
    }

    @PostMapping("/edit/{id}")
    public Integer editProduct(@PathVariable("id") Integer idProduct, @RequestBody Products product) {
        product.setId(idProduct);
        System.out.println(product);
//        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        if (product.getDescription() != null && !product.getDescription().isEmpty()) {
            product.setUserId(1);
            product.setIdImg(1);
            product.setCreateBy(1);
            product.setCategoryId(1);
            productsRepository.updateProduct(product.getId(), product.getName(),
                    product.getDescription(), product.getImgProduct(), product.getNewPrice(), product.getOldPrice(),
                    product.getPromotion(), product.getStar());
        } else {
            return 4;
        }
        return 0;
    }

    @PostMapping("/image-edit/{id}")
    public Integer editImageProduct(@PathVariable("id") Integer idImageProduct, @RequestBody ImageProduct imageProduct) {
        imageProduct.setId(idImageProduct);
        System.out.println(imageProduct);
//        ProductModel productModel = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        if (imageProduct.getImgProduct1() != null && !imageProduct.getImgProduct1() .isEmpty()) {
            imageProduct.setCreateBy(1);
            imageProductRepository.updateImageProduct(imageProduct.getId(), imageProduct.getImgProduct1(),
                    imageProduct.getImgProduct2(), imageProduct.getImgProduct3(), imageProduct.getImgProduct4()
                    , imageProduct.getImgProduct5());
        } else {
            return 4;
        }
        return 0;
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
    @PostMapping(value = "/img_product")
    @ResponseBody
    public int createImgProduct(@RequestBody ImageProduct imgProduct) {
        if(imgProduct.getImgProduct1() != null) {
            imgProduct.setCreateBy(1);
            imageProductRepository.save(imgProduct);
        }else {
            return 1;
        }
        return 0;

    }

    @PostMapping(value = "/create")
    @ResponseBody
    public int createProduct(@RequestBody Products product) {
        if(product.getName() != null && product.getDescription() != null) {
            product.setUserId(1);
            product.setIdImg(1);
            product.setCreateBy(1);
            product.setCategoryId(1);
            productsRepository.save(product);
        }else {
            return 4;
        }
        return 0;

    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer idProduct) {
        if(idProduct != null) {
            productsRepository.deleteById(idProduct);
        }else {
            System.out.println("errors");
        }

        return "redirect:/product/deleteProduct";

    }
}
