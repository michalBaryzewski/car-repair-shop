package com.cwm.carworkshop.repository;

import com.cwm.carworkshop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
