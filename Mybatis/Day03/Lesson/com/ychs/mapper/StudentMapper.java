/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.mapper;

import com.ychs.pojo.Student;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 9:50
 */
public interface StudentMapper {
    public List<Student> getStudentAndClazz();

    public List<Student> getStuAndClazzAndCourse();

    public List<Student> lazyGetStudent();
}
