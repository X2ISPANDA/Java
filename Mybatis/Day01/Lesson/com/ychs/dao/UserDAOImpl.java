/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import com.ychs.bean.User;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 17:30
 */
public class UserDAOImpl implements UserDao {

    @Override
    public User getUserByUsername(String username) throws IOException {
//        //1.需要加载mybatis的总配置文件
//        String resource = "SqlMapConfig.xml";
//        InputStream is = Resources.getResourceAsStream(resource);
//        //2.创建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //3.通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.操作sql语句
        sqlSession.selectOne("user.selectUserByUsername", username);
        //5.返回结果集
        return null;
    }
}
