/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.mapper.ClazzMapper;
import com.ychs.pojo.Clazz;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 10:51
 */
public class TestClazz {
    @Test
    public void getClazzAndStudent() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        List<Clazz> list = mapper.getClazzAndStudent();
        System.out.println(list);
        sqlSession.close();
    }
}
