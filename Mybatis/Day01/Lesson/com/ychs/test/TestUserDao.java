/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.bean.User;
import com.ychs.dao.UserDAOImpl;
import com.ychs.dao.UserDao;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 19:24
 */
public class TestUserDao {
    @Test
    public void getUserByUsername() throws IOException {
        UserDao dao = new UserDAOImpl();
        User user = dao.getUserByUsername("张三");
        System.out.println(user);
    }
}
