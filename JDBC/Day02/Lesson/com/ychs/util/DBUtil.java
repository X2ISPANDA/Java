/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.util;

import java.sql.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:19
 */
public class DBUtil {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            // 1.注册驱动  包名+类名(全限定名)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // 2.获取数据库连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "scott",
                    "scott");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 释放资源
     */
    public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs){
        if (rs!=null){
            try {
                //ctrl+shift+上下箭头  上下移动
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
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
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
    }
}
