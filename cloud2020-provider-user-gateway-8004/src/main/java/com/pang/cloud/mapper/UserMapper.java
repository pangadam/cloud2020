package com.pang.cloud.mapper;

import com.pang.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int addUser(User user);

    User getUser(@Param("id") Integer id);

}
