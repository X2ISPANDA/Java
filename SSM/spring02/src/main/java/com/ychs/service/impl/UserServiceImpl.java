package com.ychs.service.impl;

import com.ychs.pojo.User;
import com.ychs.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:23
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUsers() {
        System.out.println("查询页面");
        List<User> list = new ArrayList();
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        list.add(user);
        return list;
    }

    @Override
    public int addUser(User user) {
//        int i=1/0;
        System.out.println("添加用户");
        return 1;
    }

    @Override
    public int delUser(User user) {
        System.out.println("删除用户");
        return 1;
    }
}
