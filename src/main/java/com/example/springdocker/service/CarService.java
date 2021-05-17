package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository repository;

    public List<Car> getAll() {
        return repository.findAll();
    }

    public Car saveNewCar(Car car) {
        validateCar(car);

        boolean found = repository.existsCarByMakeIgnoreCaseAndModelIgnoreCase(car.getMake(), car.getModel());
        if (found) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car already exists.");
        }
        return repository.save(car);
    }

    private void validateCar(Car car) {
        if (car.getMake() == null || car.getModel() == null || car.getMake().isEmpty() || car.getModel().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Both Make and Model must exist.");
        }
    }
}
