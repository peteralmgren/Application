package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    boolean existsCarByMakeIgnoreCaseAndModelIgnoreCase(String make, String model);
}
