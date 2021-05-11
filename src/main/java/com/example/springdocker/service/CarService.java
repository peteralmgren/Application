package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.CarRepository;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carrepository;

    public List<Car> getCars() {
        return carrepository.findAll();
    }

    public void saveNewCar(Car car) {
        carrepository.save(car);
    }

    public List<String> getDrivableCars() {
        // hämtar alla Cars som vi kan köra
        List<Car> drivableCars = carrepository.findCarByCanIDriveIt(true);

        // returnerar endast Car namnen i en lista
        return drivableCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
