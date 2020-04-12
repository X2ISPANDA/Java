/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.service;

import com.ychs.bean.Page;
import com.ychs.bean.School;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/22 11:01
 */
public interface SchoolService {

    Page<School> querySchool(School school);

}
