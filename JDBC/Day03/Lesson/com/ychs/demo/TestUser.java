/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.bean.User;
import com.ychs.dao.UserDao;
import com.ychs.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 14:54
 */
public class TestUser {
    private static final Logger logger = LogManager.getLogger(TestUser.class);

    @Test
    public void addUser() throws SQLException {
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("xxx");
        user.setPassword("Tent");
        int result = dao.addUser(user);
        logger.debug(result);
    }

    @Test
    public void editUser() throws SQLException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("xxx");
        user.setPassword("444");
        int result = userDao.editUser(user);
        logger.debug(result);

    }

    @Test
    public void deleteUser() throws SQLException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("xxx");
        int result = userDao.deleteUser(user);
        logger.debug(result);

    }

    @Test
    public void getUserByUsername() throws SQLException {
        UserDao dao = new UserDao();
        User user = dao.getUserByUsername("aa");
        logger.debug(user);
    }

    @Test
    public void getUsers() throws SQLException {
        UserDao dao = new UserDao();
        List<User> users = dao.getUsers("a");
        logger.debug(users);
    }
}




