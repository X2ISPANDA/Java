/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import org.junit.Test;

import java.sql.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/19 11:05
 */
public class Clazz {
    String cno="1005";
    String cname="5班";
    @Test
    public void addClazz() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                "scott",
                "scott");
        //3.编写SQL
        //String sql="insert into t_class values('1005','5班')";
        String sql="insert into t_class(cno,cname) values('"+cno+"','"+cname+"')";
        //4.获取语句的执行者
        Statement stat = conn.createStatement();
        //5.执行SQL语句
        int result = stat.executeUpdate(sql);
        System.out.println(result);
        //6.关闭资源,释放连接
        stat.close();
        conn.close();
    }

    @Test
    public void delClazz() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                "scott",
                "scott");
        //3.编写SQL
        String sql = "delete from t_class where cno=?";
        //4.获取预编译语句的执行者
        PreparedStatement ps = conn.prepareStatement(sql);
        //4-1 设置参数
        ps.setString(1,"1005");
        //5.执行SQL
        int result = ps.executeUpdate();
        System.out.println(result);
        //6.释放资源
        ps.close();
        conn.close();
    }

    @Test
    public void editClazz() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC",
                "root",
                "root");
        //3.编写sql
        String sql = "UPDATE account SET MONEY=?,UID=? WHERE ID=?";
        //4.获取预编译语句的执行者
        PreparedStatement ps = conn.prepareStatement(sql);
        //5.设置参数
        ps.setDouble(1,1500);
        ps.setInt(2,42);
        ps.setInt(3,3);
        //6.执行SQL
        int result = ps.executeUpdate();
        System.out.println(result);
        //7.释放资源
        ps.close();
        conn.close();
    }

    @Test
    public void getClazz() {
        ResultSet rs=null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stumanager?serverTimezone=UTC",
                    "root",
                    "root");
            //3.编写sql
            String sql = "SELECT * FROM t_clazz";
            //4.获取预编译语句的执行对象
            ps = conn.prepareStatement(sql);
            //5.设置参数
            //6.执行SQL
           rs = ps.executeQuery();
            //7.遍历结果集
            while (rs.next()) {
                System.out.println(rs.getString("cno") + "," +
                        rs.getString("cname"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //8.释放资源
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
