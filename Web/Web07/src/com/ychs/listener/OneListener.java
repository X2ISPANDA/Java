/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.listener;
/**
 * @description:
 * @author Mingyu Xiong
 * @date 2020/4/11 13:31
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("全局作用域对象被初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("全局作用域对象被销毁");
    }
}
