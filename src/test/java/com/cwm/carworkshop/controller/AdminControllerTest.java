package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.*;
import com.cwm.carworkshop.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Test
    public void whenFindByName_thenReturnUser() {
        User user = new User();
        user.setUsername("test");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPassword("password");
        entityManager.persist(user);
        entityManager.flush();

        User found = userRepository.findByUsername("test");

        assertThat(found.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    public void whenFindByOwner_thenReturnCars() {
        User user = new User();
        user.setUsername("test");
        user.setFirstName("name");
        user.setLastName("name");
        user.setPassword("name");
        entityManager.persist(user);

        Car car = new Car();
        car.setOwner(user);
        entityManager.persist(car);
        entityManager.flush();

        List<Car> found = carRepository.findAllByOwner(user);

        assertThat(found.get(0).getOwner()).isEqualTo(user);
    }

    @Test
    public void whenFindByClient_thenReturnTask() {
        User user = new User();
        user.setUsername("test");
        user.setFirstName("name");
        user.setLastName("name");
        user.setPassword("name");
        entityManager.persist(user);

        List<User> userList = Collections.singletonList(user);

        Task task = new Task();
        task.setClients(userList);
        entityManager.persist(task);
        entityManager.flush();

        List<Task> found = taskRepository.findAllByClients(user);

        assertThat(found.get(0)).isEqualTo(task);
    }

    @Test
    public void whenFindByName_thenReturnRole() {
        Role role = new Role();
        role.setName("role");
        entityManager.persist(role);
        entityManager.flush();

        Set<Role> found = roleRepository.findAllByName(role.getName());

        assertThat(found.iterator().next().getName()).isEqualTo(role.getName());
    }

    @Test
    public void whenFindByStatus_thenReturnTaskStatus() {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setStatus("status");
        entityManager.persist(taskStatus);
        entityManager.flush();

        TaskStatus found = taskStatusRepository.findByStatus(taskStatus.getStatus());

        assertThat(found.getStatus()).isEqualTo(taskStatus.getStatus());
    }

}