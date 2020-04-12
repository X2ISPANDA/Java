/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.bean.User;
import com.ychs.util.C3P0Util;
import com.ychs.util.DBCPUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 9:08
 */
public class HandlerDemo {
    @Test
    public void arrayHandlerDemo() throws SQLException {
        //1.创建queryrunnner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.编写sql
        String sql = "select * from t_user where username = ?";
        //3.用qr对象执行sql
        Object[] query = qr.query(sql, new ArrayHandler(), new Object[]{"aa"});
        System.out.println(Arrays.toString(query));
        //Arrays.asList();
        //list.toArray();
        //Arrays.toString();
    }

    @Test
    public void arrayListHandlerDemo() throws SQLException {
        //1.创建queryrunnner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.编写sql
        String sql = "select * from t_user";
        //3.用qr对象执行sql
        List<Object[]> query = qr.query(sql, new ArrayListHandler());
        for (Object[] objects : query) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void beanHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from t_user";
        User user = qr.query(C3P0Util.getConnection(), sql, new BeanHandler<User>(User.class));
        System.out.println(user);
    }

    @Test
    public void beanListHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from t_user";
        List<User> query = qr.query(C3P0Util.getConnection(), sql, new BeanListHandler<User>(User.class));
        System.out.println(query);
    }

    @Test
    public void columnListHandler() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select username from t_user";
        List<String> query = queryRunner.query(sql, new ColumnListHandler<>());
        System.out.println(query);
    }

    @Test
    public void scalarHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select count(*) from t_user";
        BigDecimal res = qr.query(sql, new ScalarHandler<>());
        System.out.println(res);
    }

    @Test
    public void mapHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select * from t_user";
        Map<String, Object> query = qr.query(sql, new MapHandler());
        System.out.println(query);
    }

    @Test
    public void mapListHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select * from t_user";
        List<Map<String, Object>> query = qr.query(sql, new MapListHandler());
        System.out.println(query);
    }

    @Test
    public void keyedHandlerDemo() throws SQLException {
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select * from t_user";
        Map<Object, Map<String, Object>> query = qr.query(sql, new KeyedHandler<>());
        System.out.println(query);
    }
}
