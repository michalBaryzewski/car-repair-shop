package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Task;
import com.cwm.carworkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    
    List<Task> findAllByClients(User user);
}
