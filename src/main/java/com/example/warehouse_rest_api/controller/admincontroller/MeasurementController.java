package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.MeausurementDto;
import com.example.warehouse_rest_api.repository.MeasurementRepository;
import com.example.warehouse_rest_api.service.adminservice.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    MeasurementService measurementService;
    @GetMapping("/list")
    public ApiResponse getAll(){
        return measurementService.all();
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody MeausurementDto meausurementDto){
        return measurementService.add(meausurementDto);
    }
    @PostMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody MeausurementDto dto){
        return measurementService.edit(id,dto);
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return measurementService.delete(id);
    }
}
