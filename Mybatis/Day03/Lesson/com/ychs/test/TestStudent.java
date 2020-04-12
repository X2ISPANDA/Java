/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.test;

import com.ychs.mapper.StudentMapper;
import com.ychs.pojo.Student;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/9 10:07
 */
public class TestStudent {
    @Test
    public void getStudentAndClazz() throws IOException {
        //读取配置文件
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //通过工厂类创建SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过sqlSession获取代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudentAndClazz();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void getStuAndClazzAndCourse() throws IOException {
        //读取配置文件
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //通过工厂类创建SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过sqlSession获取代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStuAndClazzAndCourse();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void lazyGetStudent() throws IOException {
        //读取配置文件
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //通过工厂类创建SQLSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过sqlSession获取代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.lazyGetStudent();
        System.out.println(list);
        sqlSession.close();
    }
}
