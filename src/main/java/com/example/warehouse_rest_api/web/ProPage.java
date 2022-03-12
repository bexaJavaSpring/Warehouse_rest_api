package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.ProductDto;
import com.example.warehouse_rest_api.entity.Product;
import com.example.warehouse_rest_api.repository.*;
import com.example.warehouse_rest_api.service.adminservice.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product/bexruz")
public class ProPage {
     @Autowired
    MeasurementRepository measurementRepository;

     @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @GetMapping
    public String getPro(Model model){
        model.addAttribute("productList", productRepository.findAll());
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "bexruz-pro";
    }
    @GetMapping("/{id}")
    public String getOnePro(@PathVariable Integer id,Model model){
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.get();
        model.addAttribute("product",product);
        return "pro-detail";
    }
    @GetMapping("/add")
    public String addPro(Model model){
        model.addAttribute("warehouseList",warehouseRepository.findAll());
    model.addAttribute("categoryList",categoryRepository.findAll());
    model.addAttribute("measurementList",measurementRepository.findAll());
    model.addAttribute("attachmentList",attachmentRepository.findAll());
        return "add-pro";
    }

    @PostMapping("/add")
    public String addProSavePage(@ModelAttribute ProductDto dto){
       productService.add(dto);
       return "redirect:/product/bexruz";
    }
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        model.addAttribute("product",productRepository.findById(id).get());
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "pro-edit";
    }
    @PostMapping("/edit/{id}")
    public String editSave(Model model, @PathVariable Integer id,@ModelAttribute ProductDto dto){
        productService.edit(id,dto);
      //  model.addAttribute("category", categoryRepository.findCategoryByName(dto.getCategory_name()).get());
        return "redirect:/product/bexruz";
    }
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/bexruz";
    }
    @GetMapping("/search")
    public String searchPage(Model model, @RequestParam String name) {
        model.addAttribute("productList", productRepository.findAllByNameContainingIgnoreCase(name));
        return "bexruz-pro";
    }
}
