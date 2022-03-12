package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.UsersDto;
import com.example.warehouse_rest_api.entity.Users;
import com.example.warehouse_rest_api.repository.InputRepository;
import com.example.warehouse_rest_api.repository.UsersRepository;
import com.example.warehouse_rest_api.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kirish")
public class AdminPage {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    InputRepository inputRepository;

    @PostMapping
    public String login(Model model, @ModelAttribute UsersDto dto) {
        for (Users users : usersRepository.findAll()) {
            if (users.getEmail().equals(dto.getEmail()) && users.getPassword().equals(dto.getPassword())) {
                model.addAttribute("input", inputRepository.findAll());
                model.addAttribute("warehouse", warehouseRepository.findAll());
                return "first";
            }
        }
            model.addAttribute("message", "Avval registratsiyadan o'ting! (LogIn) ");
            return "index";
    }

    @GetMapping
    public String getpage() {
        return "index";
    }

}
