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
 * @description:
 * @date 2019/11/23 9:59
 */
@WebServlet(name = "LifeServlet", urlPatterns = "/LifeServlet")
public class LifeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init.......");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<html><head>");
        resp.getWriter().write("<title>相应的页面</title>");
        resp.getWriter().write("</head><body>");
        resp.getWriter().write("<h1>hello,life</h1>");
        resp.getWriter().write("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
