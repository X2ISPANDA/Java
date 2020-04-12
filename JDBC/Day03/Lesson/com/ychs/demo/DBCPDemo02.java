/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mingyu Xiong
 * @description:DBCP读取Propercities的方式
 * @date 2019/10/26 10:20
 */
public class DBCPDemo02 {
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;

    public static void main(String[] args) throws IOException, SQLException {
        Properties prop = new Properties();
        prop.load(DBCPDemo02.class.getResourceAsStream("/dbcp.properties"));
        driverClassName = prop.getProperty("driverClassName");
        url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName(prop.getProperty("driverClassName"));
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
