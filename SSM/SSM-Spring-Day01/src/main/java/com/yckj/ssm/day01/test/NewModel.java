package com.yckj.ssm.day01.test;

import com.yckj.ssm.day01.model.ClassInfo;
import com.yckj.ssm.day01.model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/11 17:23
 */
public class NewModel {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        System.out.println(teacher);

        ClassInfo classInfo = (ClassInfo) applicationContext.getBean("classInfo");
        System.out.println(classInfo);
    }
}
