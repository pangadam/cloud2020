package com.pang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerFront80Starter {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFront80Starter.class, args);
    }

}
