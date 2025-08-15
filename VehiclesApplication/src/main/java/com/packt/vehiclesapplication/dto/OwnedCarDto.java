package com.packt.vehiclesapplication.dto;

import com.packt.vehiclesapplication.domain.entity.Car;
import com.packt.vehiclesapplication.domain.entity.Owner;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnedCarDto {
    @NotNull
    private Car car;

    @Valid
    private Owner owner;
}
