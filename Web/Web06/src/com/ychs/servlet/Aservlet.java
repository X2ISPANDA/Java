/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/9 14:57
 */
@WebServlet(name = "Aservlet", urlPatterns = "/Aservlet")
public class Aservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = UUID.randomUUID().toString();
        System.out.println("uuid:"+id);
        //创建cookie
        Cookie cookie = new Cookie("id",id);
        Cookie cookie2 = new Cookie("name","zss");
        //写到客户端
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.getWriter().write("写到客户端的cookie是："+id);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
