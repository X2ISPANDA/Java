/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import com.ychs.bean.User;

import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 17:28
 */
public interface UserDao {
    public User getUserByUsername(String username) throws IOException;


}
