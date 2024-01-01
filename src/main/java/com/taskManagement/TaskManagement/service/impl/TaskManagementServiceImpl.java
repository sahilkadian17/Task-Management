package com.taskManagement.TaskManagement.service.impl;

import com.taskManagement.TaskManagement.dtos.TaskManagementRequestDto;
import com.taskManagement.TaskManagement.dtos.TaskManagementResponseDto;
import com.taskManagement.TaskManagement.dtos.UpdateDto;
import com.taskManagement.TaskManagement.entity.Customer;
import com.taskManagement.TaskManagement.entity.TaskManagement;
import com.taskManagement.TaskManagement.enums.Status;
import com.taskManagement.TaskManagement.exceptions.GenericException;
import com.taskManagement.TaskManagement.repository.CustomerRepository;
import com.taskManagement.TaskManagement.repository.TaskManagementRepository;
import com.taskManagement.TaskManagement.service.TaskManagementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TaskManagementServiceImpl implements TaskManagementService {


    private final CustomerRepository customerRepository;
    private final TaskManagementRepository taskManagementRepository;

    @Override
    public String save(TaskManagementRequestDto taskManagementRequestDTO, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GenericException("Customer Not Found"));
        TaskManagement taskManagement = buildTaskManagement(taskManagementRequestDTO, customer);
        taskManagementRepository.save(taskManagement);
        return "Task Saved Successfully";
    }

    @Override
    public List<TaskManagementResponseDto> get(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GenericException("Customer Not Found"));
        List<TaskManagement> taskManagementList = taskManagementRepository.findAllByCustomerId(customer.getId());
        return buildTaskManagementResponseList(taskManagementList);
    }

    @Override
    public String update(UpdateDto updateDto, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GenericException("Customer Not Found"));
        updateTaskManagement(updateDto, customer);
        return "Task Updated Successfully";
    }

    @Override
    public String delete(Long customerId, Long id) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GenericException("Customer Not Found"));
        taskManagementRepository.deleteByIdAndCustomerId(id, customer.getId());
        return "Task Deleted Successfully";
    }

    private TaskManagement buildTaskManagement(TaskManagementRequestDto taskManagementRequestDto, Customer customer) {
        return TaskManagement.builder()
                .name(taskManagementRequestDto.getName())
                .description(taskManagementRequestDto.getDescription())
                .status(Status.TODO)
                .startDate(taskManagementRequestDto.getStartDate())
                .priority(taskManagementRequestDto.getPriority())
                .customer(customer)
                .build();
    }

    private List<TaskManagementResponseDto> buildTaskManagementResponseList(List<TaskManagement> taskManagementList) {
        return taskManagementList.stream()
                .map(this::buildTaskManagementResponse)
                .toList();
    }

    private TaskManagementResponseDto buildTaskManagementResponse(TaskManagement taskManagement) {
        return TaskManagementResponseDto.builder()
                .id(taskManagement.getId())
                .name(taskManagement.getName())
                .description(taskManagement.getDescription())
                .status(taskManagement.getStatus())
                .startDate(taskManagement.getStartDate())
                .endDate(taskManagement.getEndDate())
                .priority(taskManagement.getPriority())
                .customerId(taskManagement.getCustomer().getId())
                .build();
    }

    private void updateTaskManagement(UpdateDto updateDto, Customer customer) {
        TaskManagement taskManagement = taskManagementRepository.findByIdAndCustomerId(updateDto.getId(), customer.getId()).orElseThrow(() -> new GenericException("Task Not Found"));
        if (Objects.nonNull(updateDto.getName())) {
            taskManagement.setName(updateDto.getName());
        }
        if (Objects.nonNull(updateDto.getDescription())) {
            taskManagement.setDescription(updateDto.getDescription());
        }
        if (Objects.nonNull(updateDto.getStartDate())) {
            taskManagement.setStartDate(updateDto.getStartDate());
        }
        if (Objects.nonNull(updateDto.getPriority())) {
            taskManagement.setPriority(updateDto.getPriority());
        }
        taskManagementRepository.save(taskManagement);
    }
}
