package com.ychs.ssm.day07.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Mingyu Xiong
 * @description:Mybatis操作数据库的工具类
 * @date 2020/3/22 0:41
 */
public class MybatisDBUtils {

    private static SqlSessionFactory sessionFactory = null;

    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Mybatis操作数据库的一个会话,实际上将来一个会话就是一个操作数据库的完整事务.
     * @return
     */
    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }

}
