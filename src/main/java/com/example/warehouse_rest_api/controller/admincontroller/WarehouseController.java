package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.WarehouseDto;
import com.example.warehouse_rest_api.repository.WarehouseRepository;
import com.example.warehouse_rest_api.service.adminservice.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/list")
    public ApiResponse getAll(){
        return warehouseService.all();
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody WarehouseDto warehouseDto){
        return warehouseService.add(warehouseDto);
    }
    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody WarehouseDto warehouseDto){
       return warehouseService.edit(id,warehouseDto);
    }
    @PostMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return warehouseService.delete(id);
    }
}
