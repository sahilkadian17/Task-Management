package com.taskManagement.TaskManagement.controller;

import com.taskManagement.TaskManagement.dtos.*;
import com.taskManagement.TaskManagement.service.TaskManagementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new SuccessResponseDto<>(taskManagementService.save(taskManagementRequestDTO, customerId), true);
    }

    @GetMapping("/get/{customerId}")
    public ResponseDto<List<TaskManagementResponseDto>> get(@PathVariable Long customerId) {
        return new SuccessResponseDto<>(taskManagementService.get(customerId));
    }

    @PutMapping("/update/{customerId}")
    public ResponseDto<Boolean> update(@Valid @RequestBody UpdateDto updateDto, @PathVariable Long customerId) {
        return new SuccessResponseDto<>(taskManagementService.update(updateDto, customerId), true);
    }

    @DeleteMapping("/delete/{customerId}/{id}")
    public ResponseDto<Boolean> delete(@PathVariable Long customerId, @PathVariable Long id) {
        return new SuccessResponseDto<>(taskManagementService.delete(customerId, id), true);
    }
}
