package com.example.warehouse_rest_api.web;

import com.example.warehouse_rest_api.dto.InputDto;
import com.example.warehouse_rest_api.entity.Input;
import com.example.warehouse_rest_api.entity.InputProduct;
import com.example.warehouse_rest_api.repository.*;
import com.example.warehouse_rest_api.service.adminservice.InputService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/input/bexruz")
public class InputPage {
    final InputRepository inputRepository;
    final InputService inputService;
    final InputProductRepository inputProductRepository;
    final SuplierRepository suplierRepository;
    final WarehouseRepository warehouseRepository;
    final CurrencyRepository currencyRepository;
    final ProductRepository productRepository;
    public InputPage(InputRepository inputRepository, InputService inputService, InputProductRepository inputProductRepository, SuplierRepository suplierRepository, WarehouseRepository warehouseRepository, CurrencyRepository currencyRepository, ProductRepository productRepository) {
        this.inputRepository = inputRepository;
        this.inputService = inputService;
        this.inputProductRepository = inputProductRepository;
        this.suplierRepository = suplierRepository;
        this.warehouseRepository = warehouseRepository;
        this.currencyRepository = currencyRepository;
        this.productRepository = productRepository;
    }

    @GetMapping
    public String getInputList(Model model) {
        model.addAttribute("inputList", inputRepository.findAll());
        model.addAttribute("inputProducts",inputProductRepository.findAll());
        return "bexruz-input";
    }


    @GetMapping("/add")
    public String addInput(Model model) {
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        model.addAttribute("suplierList",suplierRepository.findAll());
        model.addAttribute("currencyList",currencyRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
        return "add-input";
    }
    @PostMapping("/add")
    public String addInputSave(@ModelAttribute InputDto dto){
        inputService.add(dto);
       return "redirect:/input/bexruz";
    }
    @GetMapping("/edit/{id}")
    public String editInput(@PathVariable Integer id, Model model){
       model.addAttribute("inPro",inputProductRepository.findById(id).get());
       model.addAttribute("suplierList",suplierRepository.findAll());
       model.addAttribute("warehouseList",warehouseRepository.findAll());
       model.addAttribute("currencyList",currencyRepository.findAll());
       model.addAttribute("productList",productRepository.findAll());
       return "input-edit";
    }
    @PostMapping("/edit/{id}")
    public String editInputSave(@PathVariable Integer id,@ModelAttribute InputDto dto){
        inputService.edit(id,dto);
        return "redirect:/input/bexruz";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        inputService.delete(id);
        return "redirect:/input/bexruz";
    }

//   @GetMapping("/jpql/{id}")
//    public Optional<Input> getOne(@PathVariable Integer id){
//        return inputRepository.getOneByIdJpql(id);
//   }

   @GetMapping("/{id}")
    public String getinPro(@PathVariable Integer id, Model model){
       Optional<InputProduct> byId = inputProductRepository.findById(id);
       InputProduct inputProduct = byId.get();
       model.addAttribute("inpro",inputProduct);
       return "input-detail";
   }


//    @GetMapping("/date")
//    public Slice<Input> getDate(
//            @RequestParam(value = "begin", defaultValue = com.example.warehouse_rest_api.AppConstants.DEFAULT_BEGIN_DATE) String begin,
//            @RequestParam(value = "end", defaultValue = com.example.warehouse_rest_api.AppConstants.DEFAULT_END_DATE) String end) {
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
//        return inputRepository.findAllByCreated(PageRequest.of(0, 2), timestamp, timestamp1);
//
//    }
//    @GetMapping("/pageable")
//    public Page<Input> getByPageable(
//            @RequestParam(value = "page", defaultValue = com.example.warehouse_rest_api.AppConstants.DEFAULT_PAGE_NUMBER) int page,
//            @RequestParam(value = "size", defaultValue = com.example.warehouse_rest_api.AppConstants.DEFAULT_PAGE_SIZE) int size,
//            @RequestParam(value = "sort", defaultValue = "id") String sort,
//            @RequestParam(value = "begin", defaultValue = com.example.warehouse_rest_api.AppConstants.DEFAULT_BEGIN_DATE) Timestamp begin,
//            @RequestParam(value = "end", defaultValue = AppConstants.DEFAULT_END_DATE) Timestamp end
//    ) {
//
//        return inputRepository.findAllByCreatedAtBeetwen(PageRequest.of(page, size, Sort.by(sort)), begin, end);
//    }

}
