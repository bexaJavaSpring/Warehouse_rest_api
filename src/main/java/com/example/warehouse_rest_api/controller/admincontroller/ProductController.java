package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.ProductDto;
import com.example.warehouse_rest_api.repository.ProductRepository;
import com.example.warehouse_rest_api.service.adminservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ApiResponse getAll() {
        return productService.all();
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody ProductDto productDto) {
        return productService.add(productDto);
    }

    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productService.edit(id, productDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        return productService.delete(id);
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }

}
