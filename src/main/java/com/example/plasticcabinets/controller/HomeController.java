package com.example.plasticcabinets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/home","/"})
    public String home(){
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/403")
    public String noPermission() {
        return "403";
    }

    @RequestMapping("/404")
    public String notFound() {
        return "404";
    }

    @RequestMapping("/500")
    public String internalError() {
        return "500";
    }
}
