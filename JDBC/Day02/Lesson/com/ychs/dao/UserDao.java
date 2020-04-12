/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import com.ychs.bean.User;
import com.ychs.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/20 11:17
 */
public class UserDao {
    public List<User> getUsers(User user, int page, int pagesize){
        List<User>userslist = new ArrayList<User>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //String sql = "select * FROM t_user WHERE username like ?";

        String sql = "SELECT * FROM " +
                "(SELECT a.*,rownum rn FROM " +
                "(SELECT * FROM t_user WHERE username like ? order by username) a)b WHERE b.rn>? AND b.rn<=?";
        //获取预编译语句的执行者
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,'%'+user.getUsername()+'%');
            ps.setInt(2,(page-1)*pagesize);
            ps.setInt(3,page*pagesize);
            //执行sql语句,
            rs = ps.executeQuery();
            while (rs.next()){
                User u1 = new User();
                u1.setUsername(rs.getString("username"));
                u1.setPassword(rs.getString("password"));
                userslist.add(u1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConn(conn,ps,rs);
        return userslist;
    }
}
