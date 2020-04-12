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
import java.io.PrintWriter;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/9 22:28
 */
@WebServlet(name = "OtherServlet", urlPatterns = "/OtherServlet")
public class OtherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");

        //获取Session
        HttpSession requestSession = request.getSession(false);

        String username = null;
        //从Session中读取指定属性
        if (requestSession != null) {
            username = (String) requestSession.getAttribute("username");
        }

        PrintWriter out = response.getWriter();
        out.println("OtherServlet: user = " + user);
        out.println("OtherServlet: username = " + username);
        out.print("OtherServlet: session = " + requestSession);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
