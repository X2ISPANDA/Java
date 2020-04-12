/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.task.task;import com.ychs.util.DBUtil;
import com.ychs.util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/23 10:40
 */
public class TaskOne {
    private static String username;
    private static String password;

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("请输入数字 ：0--注册，1--登录");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while (true) {
            if (i == 0) {
                while (true) {
                    System.out.println("请输入用户名:");
                    Scanner sc1 = new Scanner(System.in);
                    username = sc1.nextLine();
                    System.out.println("请输入密码");
                    Scanner sc2 = new Scanner(System.in);
                    password = sc2.nextLine();
                    conn = DBUtil2.getConnection();
                    String sql = "select * from t_user where username =" + "'" + username + "'";
                    try {
                        ps = conn.prepareStatement(sql);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            System.out.println("该用户名已被注册,请更换您的用户名再进行注册");
                            DBUtil2.closeConnection(conn, null, rs);
                            break;
                        } else {
                            String sql2 = "INSERT INTO t_user(username,password) values (?,?)";
                            try {
                                conn = DBUtil2.getConnection();
                                ps = conn.prepareStatement(sql2);
                                ps.setString(1, username);
                                ps.setString(2, password);
                                int i1 = ps.executeUpdate();
                                System.out.println("恭喜你注册成功");
                                DBUtil.closeConn(conn,ps,rs);
                                System.out.println("输入0继续注册,输入1退出系统");
                                Scanner scanner = new Scanner(System.in);
                                int i2 = scanner.nextInt();
                                if (i2 == 0) {
                                    continue;
                                } else if (i2 == 1) {
                                    System.exit(-1);
                                } else {
                                    System.out.println("您输入的有误");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            } else if (i == 1) {
                System.out.println("请输入用户名:");
                Scanner sc3 = new Scanner(System.in);
                username = sc3.nextLine();
                System.out.println("请输入密码:");
                Scanner scanner = new Scanner(System.in);
                password = scanner.nextLine();
                try {
                    conn = DBUtil2.getConnection();
                    String sql3 = "SELECT * FROM t_user WHERE username = '" + username + "' AND password = '" + password + "'";
                    ps = conn.prepareStatement(sql3);
                    ResultSet resultSet = ps.executeQuery();
                    if (resultSet.next() == true) {
                        System.out.println("登陆成功!");
                        DBUtil.closeConn(conn, ps, resultSet);
                    } else {
                        System.out.println("登陆失败!请检查你的用户名和密码是否正确");
                        DBUtil.closeConn(conn, ps, resultSet);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
