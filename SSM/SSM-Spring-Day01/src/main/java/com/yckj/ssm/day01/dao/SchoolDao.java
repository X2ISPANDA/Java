package com.yckj.ssm.day01.dao;

import org.springframework.stereotype.Component;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 12:46
 */
@Component
//@Component("schoolDao"),不显示声明beanId,那么默认的beanId为类名首字母小写
public class SchoolDao {
    public void selectSchool() {
        System.out.println("查询所有学校信息");
    }
}
