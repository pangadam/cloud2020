package com.pang.cloud.controller;

import com.pang.cloud.entity.CommonResult;
import com.pang.cloud.entity.User;
import com.pang.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/add")
    public CommonResult addUser(String username) {
        try {
            int addFlag = userService.addUser(username);
            return new CommonResult(addFlag, "添加用户成功 - x" + username, null);
        } catch (Exception e) {
            log.info("添加失败", e);
            return new CommonResult(-1, "添加用户失败", null);
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
