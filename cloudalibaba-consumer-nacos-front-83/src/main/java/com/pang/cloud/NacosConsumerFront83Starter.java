package com.pang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerFront83Starter {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerFront83Starter.class, args);
    }

}
