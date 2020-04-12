/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.util.DBUtil;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 9:24
 */
public class MyConnection {
    //连接池
    private static LinkedList<Connection> pool = new LinkedList<>();
    static{
        for (int i = 0; i < 5; i++) {
            Connection conn = DBUtil.getConnection();
            pool.addLast(conn);
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        //获取连接
        if (pool.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Connection conn = DBUtil.getConnection();
                pool.addLast(conn);
            }
        }
        Connection conn = pool.removeFirst();
        //移除并返回第一个元素
        return pool.removeFirst();
    }

    /**
     * 归还连接
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        pool.addLast(connection);
    }

    public static void main(String[] args) {
        Connection conn = MyConnection.getConnection();
        System.out.println(conn);
    }
}
