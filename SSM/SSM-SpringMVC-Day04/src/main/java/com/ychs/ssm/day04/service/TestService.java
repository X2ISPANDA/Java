package com.ychs.ssm.day04.service;

import com.ychs.ssm.day04.controller.TestController;
import com.ychs.ssm.day04.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/23 21:12
 */
@Component
public class TestService {
    @Autowired
    private TestDao testDao;

    public void test(){
        System.out.println("TestService方法执行");
    }

}
