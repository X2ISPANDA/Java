/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.task.dao;

import com.task.bean.Clazz;
import com.task.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/8 17:53
 */
public class ClazzDao {
    /**
     * 增加班级信息
     * @param clazz
     * @throws SQLException
     */
    public void addClass(Clazz clazz) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "INSERT INTO t_cla values(?,?,?)";
        queryRunner.update(sql, new Object[]{clazz.getCno(), clazz.getCname(), clazz.getCmanager()});
    }

    public void updateClass(Clazz clazz) {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "UPDATE t_cla set cno=?,cname=?,cmanager=?";
    }
}
