package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.CategoryDto;
import com.example.warehouse_rest_api.entity.Category;
import com.example.warehouse_rest_api.entity.Product;
import com.example.warehouse_rest_api.repository.CategoryRepository;
import com.example.warehouse_rest_api.repository.ProductRepository;
import com.example.warehouse_rest_api.repository.WarehouseRepository;
import com.example.warehouse_rest_api.service.adminservice.CategoryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Optional;

@Controller
@RequestMapping("/category/bexruz")
public class CatPage {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    WarehouseRepository warehouseRepository;

    @GetMapping
    public String getCat(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "bexruz-category";
    }

    @GetMapping("/{id}")
    public String getOnecat(@PathVariable Integer id, Model model) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        model.addAttribute("category", category);
        return "category-detail";
    }

    @GetMapping("/add")
    public String addCatPage(Model model) {
        model.addAttribute("warehouseList", warehouseRepository.findAll());
        return "add-category";
    }

    @PostMapping("/add")
    public String addPage(@ModelAttribute CategoryDto dto) {
        categoryService.add(dto);
        return "redirect:/category/bexruz";
    }

    @GetMapping("/edit/{id}")
    public String editSavePage(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        model.addAttribute("warehouseList", warehouseRepository.findAll());
        return "category-edit";
    }

    @PostMapping("/edit/{id}")
    public String editSavePage(@PathVariable Integer id, @ModelAttribute CategoryDto dto, Model model) {
        ApiResponse apiResponse=categoryService.edit(id, dto);
        model.addAttribute("message",apiResponse.getMessage());
        return "redirect:/category/bexruz";
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable Integer id, Model model) {
        categoryService.deleteCategoryById(id);
        model.addAttribute("message","Delete Category!");
        return "redirect:/category/bexruz";
    }

    @GetMapping("/search")
    public String searchPage(Model model, @RequestParam String name) {
        model.addAttribute("categories", categoryRepository.findAllByNameContainingIgnoreCase(name));
        return "bexruz-category";
    }
}
