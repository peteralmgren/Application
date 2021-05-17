package com.example.springdocker.service;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

//@RunWith(MokcitoRunner.class) // Junit 4
@ExtendWith(MockitoExtension.class) // Junit 5
class CarServiceTest {

    // klass vi vill testa
    CarService carService;

    @Mock
    CarRepository mockRepository;

    @BeforeEach
    public void init() {
        carService = new CarService(mockRepository);
    }

    @Test
    void getAll() {
        Car mockCar = new Car();
        mockCar.setMake("make1");
        String expectedModel = "model1";

        mockCar.setModel(expectedModel);

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockCar));

        //        ------------------------------------


        // anropa våran metod
        List<Car> actual = carService.getAll();

//        ------------------------------------

        assertEquals(mockCar.getMake(), actual.get(0).getMake());
        assertEquals(expectedModel, actual.get(0).getModel());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();
    }

    @Test
    void save_successful() {
        String expectedMake = "make";
        String expectedModel = "Model";

        Car savingCar = new Car();
        savingCar.setMake(expectedMake);
        savingCar.setModel(expectedModel);

        when(mockRepository.save(any()))
                .thenReturn(savingCar);
        // -----------------------------------

        Car actual = carService.saveNewCar(savingCar);

        // ----------------------------------

        assertEquals(savingCar.getMake(), actual.getMake());
        assertEquals(savingCar.getModel(), actual.getModel());

        verify(mockRepository).save(any());
        verify(mockRepository).existsCarByMakeIgnoreCaseAndModelIgnoreCase(anyString(), anyString());
    }

    @Test
    void save_invalid() {
        Car invalidCar = new Car();
        // -----------------------------------

        assertThrows(ResponseStatusException.class, () -> carService.saveNewCar(invalidCar));

        // ----------------------------------

        verify(mockRepository, times(0)).save(any());
        verify(mockRepository, times(0)).existsCarByMakeIgnoreCaseAndModelIgnoreCase(anyString(), anyString());

    }

    @Test
    void save_existing() {
        String expectedMake = "make";
        String expectedModel = "model";

        Car savingCar = new Car();
        savingCar.setMake(expectedMake);
        savingCar.setModel(expectedModel);

        when(mockRepository.existsCarByMakeIgnoreCaseAndModelIgnoreCase(anyString(), anyString()))
                .thenReturn(true);

        // -----------------------------------

        assertThrows(ResponseStatusException.class, () -> carService.saveNewCar(savingCar));

        // ----------------------------------


        verify(mockRepository, times(0)).save(any());
        verify(mockRepository).existsCarByMakeIgnoreCaseAndModelIgnoreCase(anyString(), anyString());
    }
}