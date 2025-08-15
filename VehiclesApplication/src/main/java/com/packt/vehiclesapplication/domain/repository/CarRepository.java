package com.packt.vehiclesapplication.domain.repository;

import com.packt.vehiclesapplication.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// <Car, Long> 타입의 인수는 이것이 Car 엔티티 클래스의 리포지터리이고 ID 필드의 타입이 Long임을 정의한다.
public interface CarRepository extends JpaRepository<Car, Long> {
    // 브랜드로 자동차 검색
    List<Car> findByBrand(String brand);
    // 아이디로 자동차 검색
    Car findById(long id);
    // 색상으로 자동차 검색
    List<Car> findByColor(String color);
    // 모델로 자동차 검색
    List<Car> findByModel(String model);
    // 제작연도와 모델로 자동차 검색
    List<Car> findByModelAndModelYear(String model, int year);
    // 제작연도와 브랜드로 자동차 검색
    List<Car> findByModelYearAndBrand(int year, String brand);
    // 제작연도와 모델과 브랜드로 자동차 검색
    List<Car> findByModelYearAndModelAndBrand(int year, String brand, String model);
    // 연도로 자동차 검색
    List<Car> findByModelYear(int modelYear);
    // 브랜드와 모델로 자동차 검색
    List<Car> findByBrandAndModel(String brand, String model);
    // 브랜드와 색상으로 자동차 검색
    List<Car> findByBrandAndColor(String brand, String color);
    // 브랜드 또는 색상별로 자동차 검색
    List<Car> findByBrandOrColor(String brand, String color);
    // 브랜드와 모델 또는 색상 별로 자동차 검색
    List<Car> findByBrandAndModelOrColor(String brand, String model, String color);
    // 브랜드와 모델과 색상 별로 자동차 검색
    List<Car> findByBrandAndModelAndColor(String brand, String model, String color);
    // 제작연도 오름차순대로 브랜드로 자동차 검색
    List<Car> findByBrandOrderByModelYearAsc(String brand);
    // 등록번호 존재하는지 확인
    Boolean existsByRegistrationSeq(String registrationSeq);
}
