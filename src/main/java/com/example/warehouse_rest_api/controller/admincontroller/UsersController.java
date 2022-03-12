package com.example.warehouse_rest_api.controller.admincontroller;

import com.example.warehouse_rest_api.dto.ApiResponse;
import com.example.warehouse_rest_api.dto.UsersDto;
import com.example.warehouse_rest_api.entity.Users;
import com.example.warehouse_rest_api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @GetMapping("/list")
    public ApiResponse getAll(){
        List<Users> all = usersRepository.findAll();
        return new ApiResponse("Mana",true,all);
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody UsersDto dto){
        ApiResponse  apiResponse=new ApiResponse();
        for (Users users : usersRepository.findAll()) {
            if(users.getName().equals(dto.getName())){
               apiResponse.setMessage("This user already exist");
               apiResponse.setSuccess(false);
            }
        }
        Users users=new Users();
        users.setName(dto.getName());
        users.setActive(dto.isActive());
        users.setEmail(dto.getEmail());
        users.setPhone(dto.getPhone());
        users.setPassword(dto.getPassword());
        Users save=usersRepository.save(users);
        return new ApiResponse("Added",true,save);
    }
    @PostMapping("/edit/{id}")
    public ApiResponse block(@PathVariable Integer id){
        Optional<Users> byId = usersRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Users users=byId.get();
        users.setActive(false);
        return new ApiResponse("Bloklandi",true);
    }


}
