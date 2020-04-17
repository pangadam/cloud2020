package com.pang.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service :
                services) {
            log.info("Service : " + service);
            System.out.println("***instance list***");
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance serviceInstance :
                    instances) {
                log.info("Service Instance id : " + serviceInstance.getInstanceId());
            }
        }
        return this.discoveryClient;
    }

}
