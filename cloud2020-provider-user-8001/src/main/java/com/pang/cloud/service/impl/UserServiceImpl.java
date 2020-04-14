package com.pang.cloud.service.impl;

import com.pang.cloud.entity.User;
import com.pang.cloud.mapper.UserMapper;
import com.pang.cloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(String username) {
        return userMapper.addUser(new User(username));
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}
