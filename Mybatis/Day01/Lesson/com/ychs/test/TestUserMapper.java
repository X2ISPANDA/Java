/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.bean.User;
import com.ychs.mapper.UserMapper;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 20:21
 */
public class TestUserMapper {

    @Test
    public void insertUser() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("ss");
        user.setPassword("65888");
        int i = mapper.insertUser(user);
        System.out.println(i);
        session.commit();
        session.close();
    }

    @Test
    public void getUsersByUsername() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.getUsersByUsername("s");
        System.out.println(list);
        session.close();
    }

}
