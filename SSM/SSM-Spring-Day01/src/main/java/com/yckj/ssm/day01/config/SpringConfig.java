package com.yckj.ssm.day01.config;

import com.yckj.ssm.day01.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/18 19:16
 */
@Configuration
public class SpringConfig {
    @Bean(name = "student")
    public Student getStudent() {
        Student student = new Student();
        student.setStuId(1);
        student.setAge(18);
        student.setName("张三");
        return student;
    }
}
