package com.ychs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static synchronized SqlSessionFactory getSqlSessionFactory() throws IOException {
        if(sqlSessionFactory==null){
            String resource = "SqlMapConfig.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
            return sqlSessionFactory;
    }
}
