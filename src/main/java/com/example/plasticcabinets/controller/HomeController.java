package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.model.ImageProduct;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.repository.ImageProductRepository;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class HomeController {
    private List<Products> allProduct = new ArrayList<>();
    private List<Users> allUser = new ArrayList<>();
    private List<ImageProduct> allImageProduct = new ArrayList<>();

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageProductRepository imageProductRepository;

    @RequestMapping("/home")
    public String home(Model model){
        allProduct = productsRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        model.addAttribute("lstProduct", allProduct);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/index";
    }

    @RequestMapping("/createProduct")
    public String createProduct(Model model) {
        allProduct = productsRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        model.addAttribute("lstProduct", allProduct);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/createProduct";
    }

    @RequestMapping("/createUser")
    public String createUser(Model model) {
        allUser = userRepository.findAll();
        model.addAttribute("allUser", allUser);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/createUser";
    }

    @RequestMapping("/editProduct")
    public String editProduct(Model model) {
        allProduct = productsRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        model.addAttribute("lstProduct", allProduct);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/editProduct";
    }

    @RequestMapping("/editUser")
    public String editUser(Model model) {
        allUser = userRepository.findAll();
        model.addAttribute("allUser", allUser);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/editUser";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(Model model) {
        allProduct = productsRepository.findAll();
        allImageProduct = imageProductRepository.findAll();
        model.addAttribute("lstProduct", allProduct);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/deleteProduct";
    }


    @RequestMapping("/deleteUser")
    public String deleteUser(Model model) {
        allUser = userRepository.findAll();
        model.addAttribute("allUser", allUser);
        model.addAttribute("allImageProduct", allImageProduct);
        return "admin/page/deleteUser";
    }


}
