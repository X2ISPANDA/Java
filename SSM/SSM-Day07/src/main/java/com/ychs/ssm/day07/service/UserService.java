package com.ychs.ssm.day07.service;

import com.ychs.ssm.day07.mapper.UserInfoMapper;
import com.ychs.ssm.day07.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:用户管理业务处理层
 * @date 2020/3/25 18:30
 */
//@Component
@Service
public class UserService {

    /**
     * 用户信息表数据库操作实体
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    public UserInfo queryUserByName(String username) {
        UserInfo userInfo = userInfoMapper.selectUserByName(username);
        return userInfo;
    }

    public List<UserInfo> queryUserMultiple(UserInfo userInfo) {
        return userInfoMapper.selectUserMultiple(userInfo);
    }
}
