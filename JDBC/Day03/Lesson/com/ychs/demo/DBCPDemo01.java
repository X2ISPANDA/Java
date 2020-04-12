/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:DBCPDemo
 * @date 2019/10/26 10:02
 */
public class DBCPDemo01 {
    private static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USERNAME = "scott";
    private static final String PASSWORD = "scott";

    public static void main(String[] args) throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DRIVER_CLASS_NAME);
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        //归还连接
        ds.close();
    }

}
