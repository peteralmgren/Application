package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    boolean existsCarByMakeIgnoreCaseAndModelIgnoreCase(String make, String model);
}
