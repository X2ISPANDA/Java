/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.mapper.TUserMapper;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/10 9:35
 */
public class TestUser {

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        TUserMapper mapper = session.getMapper(TUserMapper.class);
        mapper.selectByPrimaryKey("aa");
    }
}
