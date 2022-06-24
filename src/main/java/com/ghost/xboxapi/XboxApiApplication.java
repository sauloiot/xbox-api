package com.ghost.xboxapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class XboxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XboxApiApplication.class, args);
    }

}
