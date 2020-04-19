package com.pang.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pang.cloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/handler/{id}")
    @SentinelResource(value = "handler", blockHandler = "blockHandler", fallback = "fallback")
    public CommonResult handler(@PathVariable Integer id) {

        if(id == 4){
            int i = 10 / 0;
        }

        return new CommonResult(200, "程序运行正常");
    }

    public CommonResult blockHandler(@PathVariable Integer id, BlockException e) {
        return new CommonResult(444, "sentinel控制台判断违规异常 : " + e.getMessage());
    }

    public CommonResult fallback(@PathVariable Integer id, Throwable throwable) {
        return new CommonResult(555, "程序运行时异常 : " + throwable.getMessage());
    }

}
