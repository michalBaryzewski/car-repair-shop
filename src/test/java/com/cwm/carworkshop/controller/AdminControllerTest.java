package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.CarRepository;
import com.cwm.carworkshop.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminControllerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUser() {

        User user = new User();
        user.setUsername("test");
        user.setFirstName("name");
        user.setLastName("name");
        user.setPassword("name");
        entityManager.persist(user);
        entityManager.flush();

        User found = userRepository.findByUsername("test");

        assertThat(found.getUsername()).isEqualTo(user.getUsername());
    }



}