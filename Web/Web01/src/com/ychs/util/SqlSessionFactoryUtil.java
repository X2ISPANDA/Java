/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static synchronized SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            String resource = "SqlMapConfig.xml";
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return sqlSessionFactory;
    }
}
