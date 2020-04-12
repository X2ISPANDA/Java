package com.yckj.ssm.day02.test;

import com.yckj.ssm.day02.dao.UserDao;
import com.yckj.ssm.day02.services.AServices;
import com.yckj.ssm.day02.services.BServices;
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
@ContextConfiguration(locations = "classpath:spring-config02.xml")
public class SpringTest02 {

    @Autowired
    private UserDao userDao;

    @Test
    public void test01() {
        userDao.addUser();
    }
}
