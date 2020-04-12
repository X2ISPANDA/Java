/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.pojo.User;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/16 14:47
 */
public interface UserMapper {
    /**
     * 登录方法
     * @param user
     * @return
     */
    public User login(User user);
}
