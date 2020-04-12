/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/17 14:35
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、接收页面传入的用户名和密码
        response.setCharacterEncoding("utf-8");//请求的post中文乱码
//        response.setContentType("text/html;charset=utf-8");//响应的中文乱码
        response.setHeader("content-type","text/html;charset=utf-8");//不止能设置页面的编码，同时也能设置输出流的编码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+","+password);
        response.getWriter().print("成功或者失败");
        response.getWriter().write("<div  onclick=\"window.location.href='www.baidu.com'\">"+username+","+password+"</div>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
