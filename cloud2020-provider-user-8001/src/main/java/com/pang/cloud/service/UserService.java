package com.pang.cloud.service;

import com.pang.cloud.entity.User;

public interface UserService {

    int addUser(User user);

    User getUser(Integer id);

}
