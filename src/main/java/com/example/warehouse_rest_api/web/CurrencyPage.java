package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.CurrencyDto;
import com.example.warehouse_rest_api.repository.CurrencyRepository;
import com.example.warehouse_rest_api.service.adminservice.CurrencyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/currency/page")
@RequiredArgsConstructor
public class CurrencyPage {
    final CurrencyRepository currencyRepository;
    final CurrencyService currencyService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("message", "All Currency");
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "currency";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "currency";
    }

    @PostMapping("/add")
    public String addSavePage(@RequestBody CurrencyDto dto, Model model) {
        ApiResponse apiResponse = currencyService.add(dto);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "currency";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("currency", currencyRepository.findById(id).get());
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "edit-currency";
    }

    @PostMapping("/edit/{id}")
    public String editSave(@PathVariable Integer id, @RequestBody CurrencyDto dto, Model model) {
        ApiResponse apiResponse = currencyService.edit(id, dto);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "currency";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        ApiResponse apiResponse = currencyService.delete(id);
        model.addAttribute("message", apiResponse.getMessage());
        model.addAttribute("currencyList", currencyRepository.findAll());
        return "currency";
    }
}
