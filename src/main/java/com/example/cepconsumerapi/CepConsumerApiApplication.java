package com.example.cepconsumerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CepConsumerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CepConsumerApiApplication.class, args);
    }

}
