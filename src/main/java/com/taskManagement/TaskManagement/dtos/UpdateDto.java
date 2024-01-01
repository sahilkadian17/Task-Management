package com.taskManagement.TaskManagement.dtos;

import com.taskManagement.TaskManagement.enums.Priority;
import lombok.*;
import jakarta.validation.constraints.NotNull;

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
