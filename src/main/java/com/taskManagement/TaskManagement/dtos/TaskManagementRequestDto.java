package com.taskManagement.TaskManagement.dtos;

import com.taskManagement.TaskManagement.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskManagementRequestDto {

    @NotBlank(message = "Name cannot be empty")
    String name;
    String description;
    @NotNull(message = "Start Date cannot be empty")
    Long startDate;
    Priority priority;
}
