package com.training.restapi_spring_boot.app.routes;

import org.springframework.stereotype.Component;

@Component
public class BMW implements Car {
    @Override
    public String carType(){
        return "BMW Car";
    }
}
