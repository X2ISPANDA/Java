/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/17 15:44
 */
@WebServlet(name = "LifeServlet", urlPatterns = "/LifeServlet")
public class LifeServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //默认当请求第一次来到时,调用init()方法,初始化该servlet,而且是单例模式(整个tomcat只有一个该servlet),同时调用service方法,调用service方法里面会自动调用咱们自己
        //的doGet或doPost方法,每请求一次都会调用一次service方法,当容器关闭的时候会自动调用destroy方法
        System.out.println("初始化....");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
