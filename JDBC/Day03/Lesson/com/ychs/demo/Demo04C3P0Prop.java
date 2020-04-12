/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 11:29
 */
public class Demo04C3P0Prop {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
