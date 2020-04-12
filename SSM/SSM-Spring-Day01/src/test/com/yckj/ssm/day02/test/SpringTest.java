package com.yckj.ssm.day02.test;

import com.yckj.ssm.day01.dao.UserDao;
import com.yckj.ssm.day01.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/19 15:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config04.xml"})
public class SpringTest {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserDao userDao;

    @Test
    public void test01() {
        userServices.addUser();
    }
}
