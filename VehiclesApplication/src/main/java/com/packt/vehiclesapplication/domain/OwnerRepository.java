package com.packt.vehiclesapplication.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    // Owner의 name으로 조회
    List<Owner> findByName(String name);

    // Owner의 email로 조회
    Optional<Owner> findByEmail(String email);

    // 이름에 특정 문자열이 포함된 Owner 조회
    List<Owner> findByNameContaining(String keyword);

    // 특정 나이 이상인 Owner 조회
    List<Owner> findByAgeGreaterThan(int age);

    // 등록일 기준 정렬된 Owner 리스트
    List<Owner> findAllByOrderByCreatedAtDesc();

}
