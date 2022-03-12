package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.ClientDto;
import com.example.warehouse_rest_api.repository.ClientRepository;
import com.example.warehouse_rest_api.service.adminservice.ClientService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client/page")
@RequiredArgsConstructor
public class ClientPage {
    final ClientRepository clientRepository;
    final ClientService clientService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("message","All Client");
        model.addAttribute("clientList",clientRepository.findAll());
        return "client";
    }
    @GetMapping("/add")
    public String addPage(Model model){
        model.addAttribute("clientList",clientRepository.findAll());
        return "client";
    }
    @PostMapping("/add")
    public String addSave(@ModelAttribute ClientDto dto,Model model){
        ApiResponse apiResponse=clientService.add(dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("clientList",clientRepository.findAll());
        return "client";
    }
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id,Model model){
        model.addAttribute("client",clientRepository.findById(id).get());
        model.addAttribute("clientList",clientRepository.findAll());
        return "edit-client";
    }
    @PostMapping("/edit/{id}")
    public String editSave(@PathVariable Integer id,@ModelAttribute ClientDto dto,Model model){
        ApiResponse apiResponse=clientService.edit(id,dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("clientList",clientRepository.findAll());
        return "client";
    }
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id,Model model){
        ApiResponse apiResponse=clientService.delete(id);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("clientList",clientRepository.findAll());
        return "client";
    }
}
