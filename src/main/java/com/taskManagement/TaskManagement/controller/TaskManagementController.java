package com.taskManagement.TaskManagement.controller;

import com.taskManagement.TaskManagement.dtos.ResponseDto;
import com.taskManagement.TaskManagement.dtos.TaskManagementRequestDto;
import com.taskManagement.TaskManagement.dtos.TaskManagementResponseDto;
import com.taskManagement.TaskManagement.dtos.UpdateDto;
import com.taskManagement.TaskManagement.service.TaskManagementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
@AllArgsConstructor
public class TaskManagementController {

    private final TaskManagementService taskManagementService;

    @PostMapping("/save/{customerId}")
    public ResponseDto<Boolean> save(@Valid @RequestBody TaskManagementRequestDto taskManagementRequestDTO, @PathVariable Long customerId) {
        return new ResponseDto<>(taskManagementService.save(taskManagementRequestDTO, customerId), true);
    }

    @GetMapping("/get/{customerId}")
    public ResponseDto<List<TaskManagementResponseDto>> get(@PathVariable Long customerId) {
        return new ResponseDto<>(taskManagementService.get(customerId));
    }

    @PutMapping("/update/{customerId}")
    public ResponseDto<Boolean> update(@Valid @RequestBody UpdateDto updateDto, @PathVariable Long customerId) {
        return new ResponseDto<>(taskManagementService.update(updateDto, customerId), true);
    }

    @Transactional
    @DeleteMapping("/delete/{customerId}/{id}")
    public ResponseDto<Boolean> delete(@PathVariable Long customerId, @PathVariable Long id) {
        return new ResponseDto<>(taskManagementService.delete(customerId, id), true);
    }
}
