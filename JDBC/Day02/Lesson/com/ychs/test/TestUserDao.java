/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.bean.User;
import com.ychs.dao.UserDao;
import org.junit.Test;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:19
 */
public class TestUserDao {
    @Test
    public void getUsers(){
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("张");
        List<User> list = dao.getUsers(user,2,1);
        System.out.println(list);
    }
}
