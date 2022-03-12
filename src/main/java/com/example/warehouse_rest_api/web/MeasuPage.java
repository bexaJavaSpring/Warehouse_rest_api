package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.CategoryDto;
import com.example.warehouse_rest_api.dto.MeausurementDto;
import com.example.warehouse_rest_api.entity.Category;
import com.example.warehouse_rest_api.entity.Measurement;
import com.example.warehouse_rest_api.repository.MeasurementRepository;
import com.example.warehouse_rest_api.service.adminservice.MeasurementService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Controller
@RequestMapping("/measurement/bexruz")
public class MeasuPage {
    @Autowired
    MeasurementService measurementService;

    @Autowired
    MeasurementRepository measurementRepository;
    @GetMapping
    public String getMeasureement(Model model) {
        model.addAttribute("message","All Measurement");
        model.addAttribute("measurements", measurementRepository.findAll());
        return "measurement";
    }

    @GetMapping("/add")
    public String addMeaPage(Model model) {
        model.addAttribute("measurements",measurementRepository.findAll());
        return "measurement";
    }

    @PostMapping("/add")
    public String addPage(@ModelAttribute MeausurementDto dto,Model model) {
        ApiResponse apiResponse=measurementService.add(dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("measurements",measurementRepository.findAll());
        return "measurement";
    }

    @GetMapping("/edit/{id}")
    public String editSavePage(@PathVariable Integer id, Model model) {
        model.addAttribute("measurement", measurementRepository.findById(id).get());
        model.addAttribute("measurements",measurementRepository.findAll());
        return "edit-mea";
    }

    @PostMapping("/edit/{id}")
    public String editSavePage(@PathVariable Integer id, @ModelAttribute MeausurementDto dto, Model model) {
        ApiResponse apiResponse=measurementService.edit(id, dto);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("measurements",measurementRepository.findAll());
        return "measurement";
    }

    @GetMapping("/delete/{id}")
    public String deleteMea(@PathVariable Integer id,Model model) {
        ApiResponse apiResponse=measurementService.delete(id);
        model.addAttribute("message",apiResponse.getMessage());
        model.addAttribute("measurements",measurementRepository.findAll());
        return "measurement";
    }
}
