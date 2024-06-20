package com.docinhos.webdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import com.docinhos.webdev.models.UserModel;
import com.docinhos.webdev.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/listarUsuarios")
    public String getAllUsers(Model model) {
        List<UserModel> ususario = userRepository.findAll();
        model.addAttribute("usuario", ususario);
        return "listarUsuarios";
    }
    
    
}
