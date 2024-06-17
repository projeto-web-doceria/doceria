package com.docinhos.webdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class navController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
