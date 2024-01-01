package com.taskManagement.TaskManagement.repository;

import com.taskManagement.TaskManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByName(String name);
}
