/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import com.ychs.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:删除班级信息，（前提：班级信息和学员信息有主外键关系），删除班级信息时查询学员表中有没有该班级的数据，如果有，连带学员信息一并删除，并且要提示用户
 * @date 2019/10/20 14:43
 */
public class Demo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql1 = "delete from t_class where cno=?";
            String sql2 = "select count(*) from t_student where cno=?";
            String sql3 = "delete from t_student where cno=?";
            //手动开启事务
            conn.setAutoCommit(false);
            //获取预编译语句的执行对象
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "1001");
            //执行sql语句，返回影响的行数
            int res1 = ps.executeUpdate();
            ps = conn.prepareStatement(sql2);
            ps.setString(1, "1001");
            int res2 = ps.executeUpdate();
            ps = conn.prepareStatement(sql3);
            ps.setString(1, "1001");
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
