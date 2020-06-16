package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {

    TaskStatus findByStatus(String status);

}
