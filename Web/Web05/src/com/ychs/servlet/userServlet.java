/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import com.ychs.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/1/17 19:56
 */
@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        user.setUserId(1);
        user.setUsername("张三");
        user.setPassword("1024");
        request.setAttribute("user", user);

        User user1 = new User();
        user1.setPassword("WRXWRX....");
        user1.setUsername("wrx");
        user1.setUserId(1011);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        Map<String, List> map = new HashMap<>();
        map.put("list", list);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("num", 001);
        request.setAttribute("userList", list);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
