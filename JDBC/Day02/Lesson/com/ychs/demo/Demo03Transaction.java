/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:设置手动提交事务
 * @date 2019/10/20 14:17
 */
public class Demo03Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql1 = "INSERT INTO T_USER VALUES(?,?)";
            String sql2 = "INSERT INTO T_USER2 VALUES(?,?)";
            //手动开启事务
            conn.setAutoCommit(false);
            //获取预编译语句的执行对象
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "xx");
            ps.setString(2, "111111");
            //执行sql语句，返回影响的行数
            int res1 = ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setString(1, "xx");
            ps.setString(2, "111111");
            int res2 = ps.executeUpdate();

            if (res1 > 0 && res2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            DBUtil.closeConn(conn, ps, null);
        }

    }
}
