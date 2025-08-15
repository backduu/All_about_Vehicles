package com.packt.vehiclesapplication;

import com.packt.vehiclesapplication.domain.Car;
import com.packt.vehiclesapplication.domain.CarRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiclesApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(VehiclesApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(VehiclesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting VehiclesApplication");
    }
}
