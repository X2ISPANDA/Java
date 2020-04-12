/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.pojo.Clazz;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 10:37
 */
public interface ClazzMapper {
    public List<Clazz> getClazzAndStudent();

    public List<Clazz> getClazzByCno();
}
