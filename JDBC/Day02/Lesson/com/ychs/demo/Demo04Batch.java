/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.util.DBUtil;
import com.ychs.util.DBUtil2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:静态批处理
 * @date 2019/10/20 15:29
 */
public class Demo04Batch {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //获取数据库的连接
            conn = DBUtil.getConnection();
            String sql1 = "insert into t_user values('aa','111111')";
            String sql2 = "insert into t_user values('bb','111111')";
            String sql3 = "insert into t_user values('cc','123456')";
            //开启手动事务
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            //把sql添加到批处理里面
            stat.addBatch(sql1);
            stat.addBatch(sql2);
            stat.addBatch(sql3);
            //执行批处理
            int[] res = stat.executeBatch();
            System.out.println(Arrays.toString(res));
            //处理结果
            boolean flag = true;
            for (int i : res) {
                if (i <= 0) {
                    conn.rollback();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                conn.commit();
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }finally {
            DBUtil2.closeConnection(conn, stat, null);
        }

    }
}
