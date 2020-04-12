/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:32
 */
public class DBUtil2 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static{
        Properties prop = new Properties();
        try {
            prop.load(DBUtil2.class.getResourceAsStream("/db.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement stat, ResultSet rs) {
        if (rs!=null){
            try {
                //ctrl+shift+上下箭头  上下移动
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(DBUtil2.getConnection());

    }
}
