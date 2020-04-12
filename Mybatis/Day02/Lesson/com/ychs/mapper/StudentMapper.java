/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.bean.Student;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/15 21:16
 */
public interface StudentMapper {
    public Student getStudentBySno(HashMap<String,String> map);

    public HashMap<String,String> getStudentByHashMap(HashMap<String,String> map);

    public List<Student> getStuAndCname();
}
