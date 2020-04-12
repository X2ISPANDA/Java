package com.yckj.ssm.day01.test;

import com.yckj.ssm.day01.model.ClassInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/12 19:58
 */
public class Test01 {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("spring-config02.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        ClassInfo classInfo = (ClassInfo) beanFactory.getBean("classInfo");
        System.out.println(classInfo);

    }
}
