package com.packt.vehiclesapplication.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "DT_CAR")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    private String brand;

    private String model;

    private String color;

    @Column(unique=true)
    private String registrationSeq;

    @Min(1886)
    private int modelYear;

    @Min(0)
    private int price;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
