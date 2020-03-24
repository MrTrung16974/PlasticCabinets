package com.example.plasticcabinets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String home(Model model){
        String page = "/admin/page/home :: home";
        model.addAttribute("page", page);
        return "admin/index";
    }

//    @RequestMapping("/editProduct")
//    public String editProduct(Model model){
//        String page = "/admin/page/edit :: editProduct";
//        model.addAttribute("page", page);
//        return "redirect:/home";
//    }

}
