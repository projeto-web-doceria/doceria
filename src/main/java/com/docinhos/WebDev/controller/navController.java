package com.docinhos.webdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class navController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

     @GetMapping("/cadastroProduto")
     public String  produtos() {
        return "produtos";
     }

    //  @RequestMapping("/listarProduto")
    //  public String listarProduto(){
    //      return "listarProduto";
    //  }
    
    
    @GetMapping("/carrinho")
    public String  carrinho() {
        return "carrinho";
    } 
    
}
