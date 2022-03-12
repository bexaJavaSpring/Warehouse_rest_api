package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.UsersDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePage {

    @GetMapping
    public String getHomePage() {
        return "index";
    }
}
