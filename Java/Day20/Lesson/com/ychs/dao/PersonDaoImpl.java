/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 14:57
 */
public class PersonDaoImpl implements PersonDao{
    @Override
    public void add() {
        System.out.println("添加对象");
    }

    @Override
    public void delete() {
        System.out.println("删除对象");
    }

    @Override
    public void modify() {
        System.out.println("修改对象");
    }

    @Override
    public void query() {
        System.out.println("查询对象");
    }
}
