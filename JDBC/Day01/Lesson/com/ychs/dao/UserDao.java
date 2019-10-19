/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import com.ychs.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/19 15:28
 */
public class UserDao {
    List<User> list = new ArrayList<>();

    @Test
    public void login() {
        //模拟外部传入的参数
        String username = "zs123";
        String password = "123' or'1'='1";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "scott",
                    "scott");
            String sql = "select * from t_user where username='"+username+"' and password='"+password+"'";
            //String sql = "select * from t_user where username=? and password=?";
            System.out.println("sql="+sql);
            stat = conn.createStatement();
            //ps = conn.prepareStatement(sql);
           // ps.setString(1,"zs123");
            //ps.setString(2,"123 or'1'='1'");
            rs = stat.executeQuery(sql);
//            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                list.add(user);
                System.out.println(rs.getString("username") + "," +
                        rs.getString("password"));
            }
            for (User user : list) {
                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                //ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
