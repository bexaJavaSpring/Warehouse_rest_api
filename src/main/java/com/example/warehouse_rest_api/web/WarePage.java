package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.WarehouseDto;
import com.example.warehouse_rest_api.entity.Warehouse;
import com.example.warehouse_rest_api.repository.WarehouseRepository;
import com.example.warehouse_rest_api.service.adminservice.WarehouseService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/warehouse/bexruz")
public class WarePage {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public String getWar(Model model) {
        model.addAttribute("message","All Warehouses");
        model.addAttribute("warehouseList", warehouseRepository.findAll());
        return "warehouse";
    }

    @GetMapping("/{id}")
    public String getOneWar(@PathVariable Integer id, Model model) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        Warehouse warehouse = byId.get();
        model.addAttribute("warehouse", warehouse);
        return "warehouse";
    }

    @GetMapping("/add")
    public String addWarPage(Model model) {
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        return "warehouse";
    }

    @PostMapping("/add")
    public String addWarSave(@ModelAttribute WarehouseDto dto,Model model) {
        ApiResponse apiResponse=warehouseService.add(dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        return "warehouse";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("warehouse", warehouseRepository.findById(id).get());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        return "edit-warehouse";
    }

    @PostMapping("/edit/{id}")
    public String editWarSave(@PathVariable Integer id, @ModelAttribute WarehouseDto dto,Model model) {
        ApiResponse apiResponse=warehouseService.edit(id, dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        return "warehouse";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id,Model model) {
       ApiResponse apiResponse=warehouseService.delete(id);
       model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        return "warehouse";
    }
}
