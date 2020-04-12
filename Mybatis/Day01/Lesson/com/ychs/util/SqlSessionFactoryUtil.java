/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 19:40
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static synchronized SqlSessionFactory getSqlSessionFactory() throws IOException {
        if (sqlSessionFactory == null) {
            //1.需要加载mybatis的总配置文件
            String resource = "SqlMapConfig.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            //2.创建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        return sqlSessionFactory;
    }
}
