/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import com.ychs.bean.Person;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/21 15:24
 */
@WebServlet(name = "JSONUserServlet", urlPatterns = "/jsonUser")
public class JSONUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if ("aaa".equals(name)) {
            Person p = new Person("aaa", 20, "f");
            response.getWriter().write(JSONObject.fromObject(p).toString());
        } else if ("bbb".equals(name)) {
            Person p = new Person("bbb", 22, "m");
            response.getWriter().write(JSONObject.fromObject(p).toString());
        } else {
            response.getWriter().write("fail");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
