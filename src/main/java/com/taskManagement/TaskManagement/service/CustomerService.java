package com.taskManagement.TaskManagement.service;

import com.taskManagement.TaskManagement.dtos.CustomerRequestDto;
import com.taskManagement.TaskManagement.dtos.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    String save(CustomerRequestDto requestDto);

    List<CustomerResponseDto> get();
}
