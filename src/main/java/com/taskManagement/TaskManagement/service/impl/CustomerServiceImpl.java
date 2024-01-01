package com.taskManagement.TaskManagement.service.impl;

import com.taskManagement.TaskManagement.dtos.CustomerRequestDto;
import com.taskManagement.TaskManagement.dtos.CustomerResponseDto;
import com.taskManagement.TaskManagement.entity.Customer;
import com.taskManagement.TaskManagement.exceptions.GenericException;
import com.taskManagement.TaskManagement.repository.CustomerRepository;
import com.taskManagement.TaskManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String save(CustomerRequestDto requestDto) {
        Customer customer = new Customer();
        if (customerRepository.existsByName(requestDto.getName())) {
            throw new GenericException("Customer Already Exists");
        }
        customer.setName(requestDto.getName());
        customerRepository.save(customer);
        return "Customer Saved Successfully";
    }

    @Override
    public List<CustomerResponseDto> get() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(this::buildCustomerResponse)
                .toList();
    }

    private CustomerResponseDto buildCustomerResponse(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }
}
