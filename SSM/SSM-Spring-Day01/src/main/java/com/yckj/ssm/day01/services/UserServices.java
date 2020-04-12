package com.yckj.ssm.day01.services;

import com.yckj.ssm.day01.dao.SchoolDao;
import com.yckj.ssm.day01.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 12:47
 */
@Component("userServices")
public class UserServices {

    //private UserDao userDao = new UserDao();
    @Autowired
    private UserDao userDao;

    //private SchoolDao schoolDao = new SchoolDao();
    @Resource
    private SchoolDao schoolDao;

    public void addUser() {
        schoolDao.selectSchool();
        userDao.selectUserByName();
        userDao.insertUser();
    }
}
