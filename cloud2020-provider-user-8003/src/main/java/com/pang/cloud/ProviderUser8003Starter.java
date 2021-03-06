package com.pang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUser8003Starter {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUser8003Starter.class, args);
    }

}