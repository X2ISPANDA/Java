/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 10:36
 */
public class DBCPUtil {
    //数据源
    private static DataSource dataSource;

    static{
        Properties prop = new Properties();
        try {
            prop.load(DBCPUtil.class.getResourceAsStream("/dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据源
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
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
        Connection conn = DBCPUtil.getConnection();
        System.out.println(conn);
    }

}
