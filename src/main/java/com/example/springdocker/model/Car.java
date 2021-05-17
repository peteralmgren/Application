package com.example.springdocker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity

public class Car {
    @Id
    @GeneratedValue
    private UUID id;

    private String make;

    private String model;

}
