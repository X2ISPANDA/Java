/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.service.impl;

import com.ychs.bean.Page;
import com.ychs.bean.School;
import com.ychs.mapper.SchoolMapper;
import com.ychs.service.SchoolService;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/22 11:04
 */
public class SchoolServiceImpl implements SchoolService {
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public Page querySchool(School school) {
        sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
        List<School> list = mapper.getSchool(school);
        int schoolTotal = mapper.getSchoolTotal(school);

        Page page = new Page();
        page.setList(list);
        page.setCurPage(school.getCurPage());
        //通过数据库查询计算出来
        page.setTotalCount(schoolTotal);
        page.setTotalPage(schoolTotal%page.getEveryCount()==0?
                schoolTotal/page.getEveryCount():
                schoolTotal/page.getEveryCount()+1);
        return page;
    }
}
