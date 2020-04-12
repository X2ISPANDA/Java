package com.ychs.ssm.day08.test;

import com.ychs.ssm.day07.mapper.StudentMapper;
import com.ychs.ssm.day07.model.StudentInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/3/31 22:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class StudentInfoMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectStudentByIdTest() {
        StudentInfo studentInfo = studentMapper.selectStudentById(2);
        System.out.println(studentInfo);
    }

}
