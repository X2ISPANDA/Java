/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

import com.ychs.util.DBCPUtil;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 14:12
 */
public class DBCPDemo03 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = DBCPUtil.getDataSource();
        Connection conn = ds.getConnection();
        String sql = "SELECT * FROM t_test";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next() == true) {

        }
    }
}
