/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.task.dao;

import com.task.bean.Student;
import com.task.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/29 20:25
 */
public class StudentDao {
    /**
     * 增加学生信息
     * @param student
     * @return
     * @throws SQLException
     */
    public int addStudent(Student student) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.准备SQL语句
        String sql = "INSERT INTO t_stu values(?,?,?,?,?,?)";
        //3.执行SQL语句
        int result = qr.update(sql, new Object[]{student.getSno(), student.getSname(),
                student.getSex(), student.getCno(),
                student.getBirthday(), student.getTel()});
        return result;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     * @throws SQLException
     */
    public int updateStudent(Student student) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.准备SQL语句
        String sql = "update t_stu set sname=?,sex=?,cno=?,birthday=?,tel=? where sno=?";
        //3.执行SQL语句
        int result = qr.update(sql, new Object[]{student.getSname(),
                student.getSex(), student.getCno(),
                student.getBirthday(), student.getTel(),student.getSno()});
        return result;
    }

    public int seeStudent(Student student) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.准备SQL语句
        String sql = "select 33";
        //3.执行SQL语句
        int result = qr.update(sql, new Object[]{student.getSname(),
                student.getSex(), student.getCno(),
                student.getBirthday(), student.getTel(),student.getSno()});
        return result;
    }
}
