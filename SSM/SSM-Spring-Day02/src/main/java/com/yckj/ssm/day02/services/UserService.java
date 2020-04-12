package com.yckj.ssm.day02.services;

import com.yckj.ssm.day02.dao.UserDao01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/23 15:44
 */
@Component
public class UserService {
    @Autowired
    private UserDao01 userDao01;

    public void queryUser() {
        List<Map<String, Object>> list = userDao01.selectUser();
        System.out.println(list);

    }

    public void addUser() {
        userDao01.insertUser();
    }
}
