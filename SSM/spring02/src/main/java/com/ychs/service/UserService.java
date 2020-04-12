package com.ychs.service;

import com.ychs.pojo.User;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:21
 */
public interface UserService {
    public List<User> queryUsers();

    public int addUser(User user);

    public int delUser(User user);
}
