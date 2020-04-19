package com.pang.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    @SentinelResource("serviceC")
    public String serviceC(){
        log.info("--serviceC--");
        return "serviceC";
    }
}
