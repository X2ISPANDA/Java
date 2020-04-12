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
 * @description:重定向
 * @date 2019/11/17 14:24
 */
@WebServlet(name = "AServlet",urlPatterns = "/aservlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("浏览器向A借东西，A说没有，你去找B吧");
        //重定向，浏览器发出两次请求
        response.setStatus(302);//告诉浏览器重定向
        response.setHeader("Location","/web02/bservlet");
        //response.sendRedirect("/web02/bservlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
