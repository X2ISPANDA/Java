/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.service.impl;

import com.ychs.mapper.UserMapper;
import com.ychs.pojo.User;
import com.ychs.service.UserService;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/16 15:04
 */
public class UserServiceImpl implements UserService {
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public User login(User user) {
        sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.login(user);
    }
}
