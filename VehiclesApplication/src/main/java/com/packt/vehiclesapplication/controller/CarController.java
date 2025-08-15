package com.packt.vehiclesapplication.controller;

import com.packt.vehiclesapplication.domain.Car;
import com.packt.vehiclesapplication.domain.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarRepository carRepository;

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        // 자동차를 검색하고 반환
        return carRepository.findAll();
    }
}
