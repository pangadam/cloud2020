package com.pang.cloud.service;

import com.pang.cloud.entity.User;

public interface UserService {

    int addUser(String username);

    User getUser(Integer id);

}
