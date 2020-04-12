/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.service;

import com.ychs.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/24 10:11
 */
public interface UserService {
    int login(String username,String password);

}
