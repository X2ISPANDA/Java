/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/9 22:26
 */
@WebServlet(name = "SomeServlet", urlPatterns = "/SomeServlet")
public class SomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户提交参数
        String username = request.getParameter("username");

        //将参数放入request域
        request.setAttribute("user", username);

        //获取Session
        HttpSession requestSession = request.getSession();

        requestSession.setAttribute("username", username);

        response.getWriter().print("SomeServlet:" + username);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
