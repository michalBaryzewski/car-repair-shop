package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
