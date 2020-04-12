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
 * @date 2019/11/17 14:42
 */
@WebServlet(name = "CServlet", urlPatterns = "/CServlet")
public class CServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("浏览器往C借东西,C说没有,我给找D去");
        //转发
        String username = request.getParameter("username");
        System.out.println("c:"+username);
        //转发用的是内部路径,顺便把request携带的东西都转发过去了
        request.getRequestDispatcher("DServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
