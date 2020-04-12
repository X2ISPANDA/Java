package com.ychs.test;

import com.ychs.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {

    @Resource(name = "user")
    private User user;
    @Test
    public void test01(){
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        User user1 = (User) ac.getBean("user");
        System.out.println(user);
        System.out.println(user1);
        ac.close();
    }
    @Test
    public void test02(){
        System.out.println(user);
    }
}
