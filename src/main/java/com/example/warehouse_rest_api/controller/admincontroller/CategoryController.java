package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.CategoryDto;
import com.example.warehouse_rest_api.repository.CategoryRepository;
import com.example.warehouse_rest_api.service.adminservice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ApiResponse getAll(){
        return categoryService.all();
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody CategoryDto categoryDto){
        return categoryService.add(categoryDto);
    }
    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody CategoryDto categoryDto){
        return categoryService.edit(id,categoryDto);
    }
    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

}
