/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package service;

import bean.Student;
import dao.StudentDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 10:35
 */
public class StudentService {
    public Student getStudentBySno(String sno) throws SQLException {
        StudentDao dao = new StudentDao();
        return dao.getStudentBySno(sno);
    }

    public List<Student> getStudent(Student stu) throws SQLException {
        StudentDao dao = new StudentDao();
        return dao.getStudent(stu);
    }

}
