package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Car;
import com.cwm.carworkshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByOwner(User user);
}
