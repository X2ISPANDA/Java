package com.yckj.ssm.day02.test;

import com.yckj.ssm.day02.dao.UserDao;
import com.yckj.ssm.day02.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/20 13:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config03.xml")
public class SpringTest03 {

    @Autowired
    private UserService userService;

    @Test
    public void test01() {
        //userService.addUser();
        userService.queryUser();
    }
}
