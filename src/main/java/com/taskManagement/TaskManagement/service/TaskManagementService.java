package com.taskManagement.TaskManagement.service;

import com.taskManagement.TaskManagement.dtos.TaskManagementRequestDto;
import com.taskManagement.TaskManagement.dtos.TaskManagementResponseDto;
import com.taskManagement.TaskManagement.dtos.UpdateDto;

import java.util.List;

public interface TaskManagementService {

    String save(TaskManagementRequestDto taskManagementRequestDTO, Long customerId);

    List<TaskManagementResponseDto> get(Long customerId);

    String update(UpdateDto updateDto, Long customerId);

    String delete(Long customerId, Long id);
}
