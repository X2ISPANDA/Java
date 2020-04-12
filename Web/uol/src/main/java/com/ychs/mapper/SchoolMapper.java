/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.bean.School;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/22 11:27
 */
public interface SchoolMapper {
    List<School> getSchool(School school);

    int getSchoolTotal(School school);
}
