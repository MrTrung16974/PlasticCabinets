package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class HomeController {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @Autowired
    MockData mockData;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("lstProduct", mockData.getAllProduct());
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "admin/index";
    }

    @RequestMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("lstProduct", mockData.getAllProduct());
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "admin/page/createProduct";
    }

    @RequestMapping("/editProduct")
    public String editProduct(Model model) {
        mockData.setAllProduct(productsRepository.findAll());
        mockData.setAllImageProduct(imageProductRepository.findAll());
        model.addAttribute("lstProduct", mockData.getAllProduct());
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "admin/page/editProduct";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(Model model) {
        mockData.setAllProduct(productsRepository.findAll());
        mockData.setAllImageProduct(imageProductRepository.findAll());
        model.addAttribute("lstProduct", mockData.getAllProduct());
        model.addAttribute("allImageProduct", mockData.getAllImageProduct());
        return "admin/page/deleteProduct";
    }

    @RequestMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("allUser", mockData.getAllUser());
        return "admin/page/createUser";
    }



    @RequestMapping("/editUser")
    public String editUser(Model model) {
        mockData.setAllUser(userRepository.findAll());
        model.addAttribute("allUser", mockData.getAllUser());
        return "admin/page/editUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Model model) {
        mockData.setAllUser(userRepository.findAll());
        model.addAttribute("allUser", mockData.getAllUser());
        return "admin/page/deleteUser";
    }


}
