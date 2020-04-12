package com.ychs.ssm.day08.test;

import com.ychs.ssm.day07.mapper.Student01Mapper;
import com.ychs.ssm.day07.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/1 14:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class StudentInfo01MapperTest {
    @Autowired
    private Student01Mapper student01Mapper;

    @Test
    public void selectStudentByIdTest() {
        Student student = student01Mapper.selectStudentById(1);
        System.out.println(student);
    }

    @Test
    public void selectStudentMapTest() {
        List<Map<String, Object>> studentList = student01Mapper.selectStudentByMap(1);
        System.out.println(studentList);
    }
}
