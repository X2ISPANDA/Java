/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.listener; /**
 * @description:
 * @author Mingyu Xiong
 * @date 2020/4/11 15:40
 */

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TwoListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("添加了新的共享数据");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("删除了共享数据");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("更新了共享数据");
    }
}
