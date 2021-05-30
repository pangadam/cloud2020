package com.pang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GateWay9527Starter {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Starter.class, args);
    }

}
