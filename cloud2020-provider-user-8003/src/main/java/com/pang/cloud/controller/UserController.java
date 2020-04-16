package com.pang.cloud.controller;

import com.pang.cloud.entity.CommonResult;
import com.pang.cloud.entity.User;
import com.pang.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/add")
    public CommonResult<Object> addUser(@RequestBody User user) {
        try {
            int addFlag = userService.addUser(user);
            return new CommonResult<Object>(addFlag, "添加用户成功 - " + user.getUsername(), null);
        } catch (Exception e) {
            log.info("添加失败", e);
            return new CommonResult<Object>(-1, "添加用户失败", null);
        }
    }

    @GetMapping("/user/get/{id}")
    public CommonResult<User> getUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new CommonResult<User>(0, "用户数据", user);
        } else {
            return new CommonResult<User>(-1, "查询失败", null);
        }
    }

}
