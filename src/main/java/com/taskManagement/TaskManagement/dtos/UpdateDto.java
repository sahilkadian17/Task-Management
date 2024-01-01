package com.taskManagement.TaskManagement.dtos;

import com.taskManagement.TaskManagement.enums.Priority;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDto {

    @NotNull(message = "Id cannot be empty")
    Long id;
    String name;
    String description;
    Long startDate;
    Priority priority;
}
