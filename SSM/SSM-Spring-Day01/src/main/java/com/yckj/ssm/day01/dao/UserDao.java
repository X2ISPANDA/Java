package com.yckj.ssm.day01.dao;

import org.springframework.stereotype.Component;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 12:44
 */
@Component
public class UserDao {
    public void selectUserByName() {
        System.out.println("用户重名校验!");

    }

    public void insertUser() {
        System.out.println("添加用户操作!");
    }
}
