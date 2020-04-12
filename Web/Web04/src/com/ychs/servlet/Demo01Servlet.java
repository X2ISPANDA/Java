/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:servlet转发和重定向到jsp页面
 * @date 2019/11/24 10:10
 */
@WebServlet(name = "Demo01Servlet", urlPatterns = "/Demo01Servlet")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaa");
//        response.sendRedirect(request.getContextPath()+"/Demo01.jsp");
        request.setAttribute("name", "zs");
        request.getRequestDispatcher("Demo01.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
