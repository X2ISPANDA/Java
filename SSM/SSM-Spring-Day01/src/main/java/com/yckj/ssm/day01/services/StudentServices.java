package com.yckj.ssm.day01.services;

import com.yckj.ssm.day01.dao.SchoolDao;
import com.yckj.ssm.day01.dao.UserDao;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 13:44
 */
public class StudentServices {

    private UserDao userDao = new UserDao();

    private SchoolDao schoolDao = new SchoolDao();

    public void addStudent() {
        schoolDao.selectSchool();
        userDao.selectUserByName();
        userDao.insertUser();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public SchoolDao getSchoolDao() {
        return schoolDao;
    }

    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
}
