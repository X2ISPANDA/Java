/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import org.junit.Test;

import java.sql.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/14 20:33
 */
public class Test01JDBC {

    @Test
    public void test01() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "scott");
        String sql = "select * from t_user where username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,"张三");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("username") + rs.getString("password"));
        }
        rs.close();

        conn.close();
    }
}
