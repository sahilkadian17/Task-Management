package com.taskManagement.TaskManagement.entity;

import com.taskManagement.TaskManagement.enums.Priority;
import com.taskManagement.TaskManagement.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class TaskManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String description;

    Status status;

    Long startDate;

    Long endDate;

    Priority priority;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    Customer customer;
}
