/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package test;

import bean.Clazz;
import bean.Student;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 11:04
 */
public class TestStudent {
    private Logger logger = LogManager.getLogger(TestStudent.class);

    @Test
    public void getStudentBySno() throws SQLException {
        StudentService service = new StudentService();
        Student student = service.getStudentBySno("1");
        logger.debug(student);
    }

    @Test
    public void getStudent() throws SQLException {
        StudentService service = new StudentService();
        Student stu = new Student();
        stu.setSname("三");
        Clazz clazz = new Clazz();
        clazz.setCname("21");
        stu.setClazz(clazz);
        List<Student> student = service.getStudent(stu);
        String str = JSON.toJSONString(student);
        logger.debug(str);
    }
}
