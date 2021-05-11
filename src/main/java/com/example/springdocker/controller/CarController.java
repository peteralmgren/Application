package com.example.springdocker.controller;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.service.CarService;
import com.example.springdocker.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carservice;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carservice.getCars();
    }

    @PostMapping("/cars")
    public void saveNewCar(@RequestBody Car car) {
        carservice.saveNewCar(car);
    }

    @GetMapping("/cars/drivable")
    public List<String> getDrivableCar() {
        return carservice.getDrivableCars();
    }
}
