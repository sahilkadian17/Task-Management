package com.taskManagement.TaskManagement.controller;

import com.taskManagement.TaskManagement.dtos.CustomerRequestDto;
import com.taskManagement.TaskManagement.dtos.CustomerResponseDto;
import com.taskManagement.TaskManagement.dtos.ResponseDto;
import com.taskManagement.TaskManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseDto<Boolean> save(@RequestBody CustomerRequestDto requestDto) {
        return new ResponseDto<>(customerService.save(requestDto), true);
    }

    @GetMapping("/get")
    public ResponseDto<List<CustomerResponseDto>> get() {
        return new ResponseDto<>(customerService.get());
    }
}
