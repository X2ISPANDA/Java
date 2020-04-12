package com.ychs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    public static synchronized SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            //1.需要加载mybatis的总配置文件
            String resource = "SqlMapConfig.xml";
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //2.创建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        return sqlSessionFactory;
    }
}
