/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import com.ychs.util.DBUtil;
import com.ychs.util.DBUtil2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 16:00
 */
public class BatchDemo {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //获取数据库的连接
            conn = DBUtil.getConnection();
            String sql1 = "insert into t_user values('dd','567890')";
            String sql2 = "delete from t_user where username='aa'";
            String sql3 = "update t_user SET username='ee' where username='cc'";
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
