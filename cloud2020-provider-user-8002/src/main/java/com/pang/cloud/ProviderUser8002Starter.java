package com.pang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUser8002Starter {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUser8002Starter.class, args);
    }

}