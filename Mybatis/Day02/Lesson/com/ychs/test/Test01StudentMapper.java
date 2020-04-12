/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.bean.Student;
import com.ychs.mapper.StudentMapper;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/20 16:23
 */
public class Test01StudentMapper {

    @Test
    public void getStudentBySno() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa","1");
        Student stu = studentMapper.getStudentBySno(map);
        System.out.println(stu);
    }

    @Test
    public void getStudentByHashMap() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        HashMap map = new HashMap<>();
        map.put("bbb","1");
        HashMap<String,String> stuMap = studentMapper.getStudentByHashMap(map);
        System.out.println(stuMap);
        for (Object key : stuMap.keySet()) {
            Object value = stuMap.get(key);
            System.out.println(key +" "+value);
        }
    }

    @Test
    public void getStuAndCname() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = studentMapper.getStuAndCname();
        System.out.println(list);
    }
}
