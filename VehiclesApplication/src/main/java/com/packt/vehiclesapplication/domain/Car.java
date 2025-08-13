package com.packt.vehiclesapplication.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;

    private String model;

    private String color;

    @Column(unique=true)
    private String registrationSeq;

    @Min(1886)
    private int modelYear;

    @Min(0)
    private int price;

    @Override
    public String toString(){
        return String.format("%s %s (%s)", brand, model, color);
    }
}
