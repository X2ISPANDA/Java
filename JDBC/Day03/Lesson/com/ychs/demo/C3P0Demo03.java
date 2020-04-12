/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 11:10
 */
public class C3P0Demo03 {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
        ds.setUser("scott");
        ds.setPassword("scott");
        ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
