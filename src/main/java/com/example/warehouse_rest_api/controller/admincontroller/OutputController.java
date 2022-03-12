package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.OutputDto;
import com.example.warehouse_rest_api.entity.Client;
import com.example.warehouse_rest_api.entity.Currency;
import com.example.warehouse_rest_api.entity.Output;
import com.example.warehouse_rest_api.entity.Warehouse;
import com.example.warehouse_rest_api.repository.ClientRepository;
import com.example.warehouse_rest_api.repository.CurrencyRepository;
import com.example.warehouse_rest_api.repository.OutputRepository;
import com.example.warehouse_rest_api.repository.WarehouseRepository;
import com.example.warehouse_rest_api.service.adminservice.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    OutputService outputService;
    @GetMapping("/list")
    public ApiResponse getAll() {
        List<Output> all = outputRepository.findAll();
        return new ApiResponse("Mana", true, all);
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody OutputDto dto) {
       return outputService.add(dto);
    }

    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody OutputDto dto) {
       return outputService.edit(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
       return outputService.delete(id);
    }
}
