package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.service.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class LogicWebController {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    StoreFileService storeFileService;

    @Autowired
    ProductApiController productApiController;

    @Autowired
    MockData mockData;

    //    chuyển sang chi tiết sản phẩm
    @GetMapping("/detail/{id}")
    public String productDetail(@PathVariable("id") Integer idProduct, Model model) {
        Products product = null;
        for (Products p : mockData.getAllProduct()) {
            if(p.getId() == idProduct) {
                product = p;
            }
        }
        model.addAttribute("product", product);
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "web/page/detail";
    }

}
