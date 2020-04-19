package com.pang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ServiceController {

//    @Resource
//    private TestService testService;

    @GetMapping("/serviceA")
    public String serviceA() {
        log.info(Thread.currentThread().getName());
        return "serviceA";
    }

    @GetMapping("/serviceB")
    public String serviceB() {
        log.info(Thread.currentThread().getName());
        return "serviceB";
    }

    @GetMapping("/serviceD")
    public String serviceD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {

        }
        return "serviceD";
    }

    @GetMapping("/serviceE")
    public String serviceE() {
        int i = 10 / 0;
        return "serviceE - 测试异常比例";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "--------------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "--------------deal_testHotKey，/(ㄒoㄒ)/~~";
    }

}
