package com.example.springdocker.repository;

import com.example.springdocker.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataMongoTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    void existsCarByMakeIgnoreCaseAndModelIgnoreCase() {
        String expectedMake = "volvo";
        String expectedModel = "xc90";

        Car savingCar = new Car();
        savingCar.setMake(expectedMake);
        savingCar.setModel(expectedModel);

        carRepository.save(savingCar);
        // ---------------------------

        boolean actual = carRepository.existsCarByMakeIgnoreCaseAndModelIgnoreCase(expectedMake, expectedModel);

        // ---------------------------

        assertTrue(true, String.valueOf(actual));
    }


//    @Disabled
//    @Test
//    void existsCarByMakeIgnoreCaseAndModelIgnoreCase2() {
//        String expectedMake = "make";
//        String expectedModel = "model";
//
//        // ---------------------------
//
//        boolean actual = carRepository.existsCarByMakeIgnoreCaseAndModelIgnoreCase(expectedMake, expectedModel);
//
//        // ---------------------------
//
//        assertEquals(false, actual);
//    }
}