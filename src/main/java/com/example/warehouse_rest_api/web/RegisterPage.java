package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.UsersDto;
import com.example.warehouse_rest_api.repository.UsersRepository;
import com.example.warehouse_rest_api.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterPage {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserService userService;
    @GetMapping
    public String register(){
        return "register";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UsersDto dto){
        userService.saveUser(dto);
        return "redirect:/kirish";
    }
}
