/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.bean.User;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:代理的开发方式
 * @date 2019/11/15 19:46
 */
public interface UserMapper {
    public int insertUser(User user);

    public List<User> getUsersByUsername(String username);
}
