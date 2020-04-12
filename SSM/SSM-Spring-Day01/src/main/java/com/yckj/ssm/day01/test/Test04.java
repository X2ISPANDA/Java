package com.yckj.ssm.day01.test;

import com.yckj.ssm.day01.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/18 19:22
 */
public class Test04 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config04.xml");

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student );
    }
}
