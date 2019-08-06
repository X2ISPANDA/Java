/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.user;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 16:07
 */
public class UserImpl implements UserDao {

    @Override
    public boolean getUser(User user) throws IllegalPasswordException {
        System.out.println("通过数据库查询该用户是否存在");
        return true;
    }
}
