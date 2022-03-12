package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.AppConstants;
import com.example.warehouse_rest_api.dto.OutputDto;
import com.example.warehouse_rest_api.entity.OutProduct;
import com.example.warehouse_rest_api.entity.Output;
import com.example.warehouse_rest_api.repository.*;
import com.example.warehouse_rest_api.service.adminservice.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/output/bexruz")
public class OutProPage {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    OutputService outputService;
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public String getOut(Model model) {
        model.addAttribute("outProductList",outputProductRepository.findAll());
        return "bexruz-out";
    }

    @GetMapping("/{id}")
    public String getOneout(@PathVariable Integer id, Model model) {
        Optional<OutProduct> byId = outputProductRepository.findById(id);
        OutProduct outProduct = byId.get();
        model.addAttribute("outputProduct", outProduct);
        return "output-detail";
    }

    @GetMapping("/add")
    public String addOutPage(Model model) {
        model.addAttribute("productList",productRepository.findAll());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        model.addAttribute("clientList",clientRepository.findAll());
        model.addAttribute("currencyList",currencyRepository.findAll());
        return "add-output";
    }

    @PostMapping("/add")
    public String addSavePage(@ModelAttribute OutputDto dto) {
        outputService.add(dto);
        return "redirect:/output/bexruz";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Integer id, Model model) {
        model.addAttribute("output", outputProductRepository.findById(id).get());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        model.addAttribute("clientList",clientRepository.findAll());
        model.addAttribute("currencyList",currencyRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
        return "out-edit";
    }

    @PostMapping("/edit/{id}")
    public String editSavePage(@PathVariable Integer id, @ModelAttribute OutputDto dto) {
        outputService.edit(id, dto);
        return "redirect:/output/bexruz";
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable Integer id) {
        outputService.delete(id);
        return "redirect:/output/bexruz";
    }

//    @GetMapping("/date")
//    public Page<Output> getOneDate(@RequestParam String begin, @RequestParam String end) {
//        Timestamp from = Timestamp.from(Instant.parse(begin));
//        Timestamp to = Timestamp.from(Instant.parse(begin));
//        return outputRepository.kimdir(from, to);
//    }

//    @GetMapping("/date")
//    public Slice<Output> getDate(
//            @RequestParam(value = "begin", defaultValue = AppConstants.DEFAULT_BEGIN_DATE) String begin,
//            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) String end) {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsedBeginDate = null;
//        Date parsedEndDate = null;
//        try {
//            parsedBeginDate = dateFormat.parse(begin);
//            parsedEndDate = dateFormat.parse(end);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Timestamp timestamp = new java.sql.Timestamp(parsedBeginDate.getTime());
//        Timestamp timestamp1 = new java.sql.Timestamp(parsedEndDate.getTime());
//
//        return outputRepository.nimadir(PageRequest.of(0, 2), timestamp, timestamp1);
//
//    }
//    @GetMapping("/pageable")
//    public Page<Output> getByPageable(
//            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
//            @RequestParam(value = "sort", defaultValue = "id") String sort,
//            @RequestParam(value = "begin", defaultValue = AppConstants.DEFAULT_BEGIN_DATE) Timestamp begin,
//            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) Timestamp end
//    ) {
//        return outputRepository.findAllByCreatedAtBeet(PageRequest.of(page, size, Sort.by(sort)), begin, end);
//    }
}
