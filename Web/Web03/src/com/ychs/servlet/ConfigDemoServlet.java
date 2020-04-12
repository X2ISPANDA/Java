/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/23 11:16
 */
@WebServlet(name = "configDemo", urlPatterns = "/config",
        initParams = {@WebInitParam(name = "Encoding", value = "utf-8"),
                @WebInitParam(name = "name", value = "zs")
        })
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletConfig对象
        ServletConfig config = super.getServletConfig();
        //获取servlet的名称
        String servletName = config.getServletName();
        System.out.println(servletName);
        //获取servlet初始化的参数
        String encoding = config.getInitParameter("Encoding");
        System.out.println(encoding);
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
            System.out.println(config.getInitParameter(initParameterNames.nextElement()));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
