/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.task.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/29 20:09
 */
public class C3P0Util {
    //数据源
    private static ComboPooledDataSource ds = new ComboPooledDataSource();



    //获取数据源
    public static ComboPooledDataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放连接
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = C3P0Util.getConnection();
        System.out.println(conn);
    }

}
