package com.docinhos.WebDev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/produtos")
    public String  produtos() {
        return "produtos";
    }
    
    @GetMapping("/carrinho")
    public String  carrinho() {
        return "carrinho";
    } 
    
}
