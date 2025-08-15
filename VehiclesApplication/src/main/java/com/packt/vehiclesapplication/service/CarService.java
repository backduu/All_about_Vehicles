package com.packt.vehiclesapplication.service;

import com.packt.vehiclesapplication.domain.entity.Car;
import com.packt.vehiclesapplication.domain.repository.CarRepository;
import com.packt.vehiclesapplication.domain.entity.Owner;
import com.packt.vehiclesapplication.domain.repository.OwnerRepository;
import com.packt.vehiclesapplication.dto.OwnedCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
TODO: 추가해 볼 부분.
1. 조건 별 검색 기능 추가

 */
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;

    // 차량 전체 조회
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // ID로 차량 조회
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("차량을 찾지 못했습니다."));
    }

    // 차량 이름으로 차량 조회
    public List<Car> getCarByModel(String model) {
        return Optional.of(carRepository.findByModel(model))
                .filter(cars -> !cars.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("차량을 찾지 못했습니다."));
    }

    // 차량 등록
    public Car addCar(Car car) {
/*        // 차량 중복 등록 방지
        Optional.ofNullable(carRepository.existsByRegistrationSeq(car.getRegistrationSeq()))
                .filter(exists -> !exists)
                .orElseThrow(() -> new RuntimeException("이미 등록된 차량입니다."));

        return carRepository.save(car);*/
        return Optional.of(car)
                .filter(c -> !carRepository.existsByRegistrationSeq(car.getRegistrationSeq()))
                .map(carRepository::save)
                .orElseThrow(() -> new IllegalArgumentException("이미 등록된 차량입니다."));
    }

    // 사용자 등록
    public Owner addOwner(Owner owner) {
        return Optional.ofNullable(owner)
                .filter(o -> o.getId() == null)
                .map(ownerRepository::save)
                .orElseThrow(() -> new IllegalArgumentException("이미 등록된 사용자입니다."));
    }

    // 차량 사용자 등록
    public OwnedCarDto addCarToOwner(OwnedCarDto carDto)
    {
        Owner savedOwner = ownerRepository.save(carDto.getOwner());
        Car car = carDto.getCar();
        car.setOwner(savedOwner);

        Boolean exists = carRepository.existsByRegistrationSeq(car.getRegistrationSeq());
        if (exists) {
            throw new IllegalArgumentException(car.getRegistrationSeq() + "은 이미 등록된 차량입니다.");
        }

        Car savedCar = carRepository.save(car);
        return OwnedCarDto
                .builder()
                .car(savedCar)
                .owner(savedOwner)
                .build();
    }

        // 차량 정보 수정

    // 차량 삭제
}
