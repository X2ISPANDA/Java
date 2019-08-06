/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.dao;

import java.lang.reflect.Proxy;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 15:09
 */
public class ProxyDemo {
    public static void main(String[] args) {
        PersonDaoImpl dao = new PersonDaoImpl();
        MyInvocationHandler handler = new MyInvocationHandler(dao);
        //创建代理对象
        //第一个参数,代理类的加载器
        //第二个参数,代理类的所有接口
        //第三个参数,代理对象需要绑定的处理器
        PersonDao PersonDao = (PersonDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(), handler);
        PersonDao.add();
        PersonDao.delete();
        PersonDao.modify();
        PersonDao.query();
    }
}
