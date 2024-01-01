package com.taskManagement.TaskManagement.dtos;

import com.taskManagement.TaskManagement.enums.Priority;
import com.taskManagement.TaskManagement.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskManagementResponseDto {

    Long id;
    String name;
    String description;
    Long startDate;
    Long endDate;
    Status status;
    Priority priority;
    Long customerId;
}
