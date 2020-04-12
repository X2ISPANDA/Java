/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 16:22
 */
public class Demo05Batch {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into t_user values(?,?)";
            //获取预编译语句的执行对象
            ps = conn.prepareStatement(sql);
            ps.setString(1, "aaaa");
            ps.setString(2, "123456");
            //装置批处理
            ps.addBatch();
            ps.setString(1, "aaaaaaa");
            ps.setString(2, "123456");
            ps.addBatch();
            ps.setString(1, "dddddd");
            ps.setString(2, "123456");
            ps.addBatch();
            int[] res = ps.executeBatch();
            System.out.println(Arrays.toString(res));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn, ps,null);
        }
    }
}
