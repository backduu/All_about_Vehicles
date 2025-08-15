package com.packt.vehiclesapplication.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI VehiclesAppAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Vehicles REST API")
                .description("Vehicles stock")
                .version("1.0"));
    }
}
