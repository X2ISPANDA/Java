package com.ychs.service.impl;

import com.ychs.mapper.UserMapper;
import com.ychs.pojo.User;
import com.ychs.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service(value = "us")
public class UserServiceImpl implements UserService {
    @Resource(name = "userMapper")
    private UserMapper userMapper;
    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public boolean saveUser(User user) {
        int i = userMapper.saveUser(user);
        User u = new User();
        u.setUsername("xxx");
        u.setPassword("xxx");
        int a=1/0;
        int i2 = userMapper.saveUser(u);
        if(i>0&&i2>0){
            return true;
        }
        return false;
    }
}
