package com.ychs.test;

import com.ychs.service.ClazzService;
import com.ychs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext1.xml")
public class TestAop {
    @Resource(name = "userService")
    private UserService us;
    /*@Resource(name = "clazzService")
    private ClazzService cs;*/
    @Test
    public void test01(){
        us.addUser(null);
//            cs.add();
    }
}
