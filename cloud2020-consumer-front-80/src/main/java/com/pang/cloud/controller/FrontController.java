package com.pang.cloud.controller;

import com.pang.cloud.entity.CommonResult;
import com.pang.cloud.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class FrontController {

//    private String prefix = "http://localhost:8001";
    private String prefix = "http://CLOUD2020-PROVIDE-USER";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/get/{id}")
    public CommonResult<User> getUser(@PathVariable int id){
        return restTemplate.getForObject(prefix + "/user/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/user/add")
    public CommonResult<User> createUser(User user){
        return restTemplate.postForObject(prefix + "/user/add", user, CommonResult.class);
    }

}
