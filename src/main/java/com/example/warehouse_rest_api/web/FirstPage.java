package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.UsersDto;
import com.example.warehouse_rest_api.repository.ProductRepository;
import com.example.warehouse_rest_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstPage {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("productList",productRepository.findAll());
        return "first";
    }


}
