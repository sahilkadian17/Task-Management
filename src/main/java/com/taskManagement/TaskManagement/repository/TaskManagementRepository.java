package com.taskManagement.TaskManagement.repository;

import com.taskManagement.TaskManagement.entity.TaskManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskManagementRepository extends JpaRepository<TaskManagement, Long> {
    List<TaskManagement> findAllByCustomerId(Long id);

    Optional<TaskManagement> findByIdAndCustomerId(Long id, Long customerId);

    void deleteByIdAndCustomerId(Long id, Long customerId);
}
