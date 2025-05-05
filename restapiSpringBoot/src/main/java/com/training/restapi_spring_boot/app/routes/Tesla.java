package com.training.restapi_spring_boot.app.routes;

import org.springframework.stereotype.Component;

@Component
public class Tesla implements Car {
    @Override
    public String carType() {
        String color="Black";
        return "%s cyberTruck".formatted(color);
    }

}
