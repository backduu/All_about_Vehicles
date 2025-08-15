package com.packt.vehiclesapplication.controller;

import com.packt.vehiclesapplication.domain.entity.Car;
import com.packt.vehiclesapplication.domain.entity.Owner;
import com.packt.vehiclesapplication.dto.OwnedCarDto;
import com.packt.vehiclesapplication.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
    TODO: 개선해 볼 부분.
    1. List<Car> 대신 DTO로 감싸서 status, message, data 구조로 반환하면 API 응답이 더 명확하게 만들기


 */
@RestController
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    // 전체 검색
    @GetMapping("/cars")
    public ResponseEntity<?> getCars() {
        // 자동차를 검색하고 반환
        List<Car> cars = carService.getAllCars();
        return cars.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(cars);
    }

    // 차량 등록
    @PostMapping("/registerCar")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar(car));
    }

    // 사용자 등록
    @PostMapping("/registerUser")
    public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.addOwner(owner));
    }

    // 차량 사용자 등록
    @PostMapping("/registerCarWithUser")
    public ResponseEntity<OwnedCarDto> registerCarWithUser(@RequestBody OwnedCarDto ownedCarDto) {
        return Optional.ofNullable(ownedCarDto)
                .map(carService::addCarToOwner)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
