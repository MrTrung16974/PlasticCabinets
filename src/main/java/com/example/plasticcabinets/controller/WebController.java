package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.CastProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/product")
public class WebController {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    MockData mockData;

    @RequestMapping("/webHome")
    public String home(Model model){
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/index";
    }

    @RequestMapping("/pageDetail")
    public String Detail(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/detail";
    }

    @RequestMapping("/pageSearch")
    public String Search(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/searchProduct";
    }

    @RequestMapping("/pageHeader")
    public String Header(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/default/header";
    }

    @RequestMapping("/pageCast")
    public String Cast(Model model) {
        model.addAttribute("lengthProduct", mockData.getLstCastProduct().size());
        return "web/page/cast";
    }
}
