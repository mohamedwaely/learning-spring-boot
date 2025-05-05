package com.training.restapi_spring_boot.app.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class powerGym {

    Car tc;
    @Autowired
    public powerGym(@Qualifier("tesla") Car tc){
        this.tc=tc;
    }
    @GetMapping("/tesla")
    public String ctruck(){
        return tc.carType();
    }

    Car bmw;
    @Autowired
    public void setBMW(@Qualifier("BMW") Car bmw){
        this.bmw=bmw;
    }

    @GetMapping("/bmw")
    public String bmw(){
        return bmw.carType();
    }




    @Value("${apiKey}")
    private String apiKey;

    @GetMapping("/env-info")
    public String envInfo() {
        return "Together apiKey: %s".formatted(apiKey);
    }

    @GetMapping("/")
    public String hello(){
        return "hello World!";
    }


    @GetMapping("/register")
    public String register(){
        return "user registered successfully";
    }




}
