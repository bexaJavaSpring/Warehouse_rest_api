package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.SuplierDto;
import com.example.warehouse_rest_api.entity.Suplier;
import com.example.warehouse_rest_api.repository.SuplierRepository;
import com.example.warehouse_rest_api.service.adminservice.SuplierService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/supplier/bexruz")
public class SuplierPage {
    final SuplierRepository suplierRepository;
    final SuplierService suplierService;

    public SuplierPage(SuplierRepository suplierRepository, SuplierService suplierService) {
        this.suplierRepository = suplierRepository;
        this.suplierService = suplierService;
    }

    @GetMapping
    public String getAllPage(Model model) {
        model.addAttribute("message", "All Supplier");
        model.addAttribute("supplierList", suplierRepository.findAll());
        return "supplier";
    }

//    @GetMapping("/{id}")
//    public String getOnePage(@PathVariable Integer id, Model model) {
//        Optional<Suplier> byId = suplierRepository.findById(id);
//        Suplier suplier = byId.get();
//        model.addAttribute("suplier", suplier);
//        return "supplier";
//    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("supplierList", suplierRepository.findAll());
        return "supplier";
    }

    @PostMapping("/add")
    public String addSave(@ModelAttribute SuplierDto dto, Model model) {
        ApiResponse apiResponse = suplierService.add(dto);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("supplierList", suplierRepository.findAll());
        return "supplier";
    }

    @GetMapping("/edit/{id}")
    String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("suplier", suplierRepository.findById(id).get());
        model.addAttribute("supplierList",suplierRepository.findAll());
        return "edit-supplier";
    }

    @PostMapping("/edit/{id}")
    public String editSave(@PathVariable Integer id, @ModelAttribute SuplierDto dto, Model model) {
        ApiResponse apiResponse = suplierService.edit(id, dto);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("supplierList", suplierRepository.findAll());
        return "supplier";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id, Model model) {
        ApiResponse apiResponse = suplierService.delete(id);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("supplierList", suplierRepository.findAll());
        return "supplier";
    }

}
