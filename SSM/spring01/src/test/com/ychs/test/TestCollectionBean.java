package com.ychs.test;

import com.ychs.pojo.CollectionBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:53
 */
public class TestCollectionBean {

    @Test
    public void test01(){
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        CollectionBean cb = (CollectionBean) ac.getBean("cb");
        System.out.println(cb);

    }
}
