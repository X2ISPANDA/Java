/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/24 10:20
 */
public interface UserMapper {
    User login(@Param("username") String username,@Param("password") String password);
}
