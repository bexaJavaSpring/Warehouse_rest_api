package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.CurrencyDto;
import com.example.warehouse_rest_api.repository.CurrencyRepository;
import com.example.warehouse_rest_api.service.adminservice.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;
     @Autowired
    CurrencyService currencyService;

    @GetMapping("/list")
    public ApiResponse getAll() {
        return currencyService.all();
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody CurrencyDto currencyDto) {
       return currencyService.add(currencyDto);
    }
    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody CurrencyDto dto){
       return currencyService.edit(id,dto);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
       return currencyService.delete(id);
    }
}
