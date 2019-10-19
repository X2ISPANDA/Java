/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/19 9:42
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动 //包名+类名
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE&serverTimezone=UTC", "root", "root");
        System.out.println(conn);
    }
}
