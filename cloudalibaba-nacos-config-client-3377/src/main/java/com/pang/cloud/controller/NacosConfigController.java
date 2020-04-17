package com.pang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${nacos.config.name:未配置}")
    private String testNacosCOnfig;

    @GetMapping("/configinfo")
    public String getTestNacosCOnfig(){
        return testNacosCOnfig;
    }

}
