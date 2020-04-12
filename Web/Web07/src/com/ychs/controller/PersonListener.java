/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import com.ychs.bean.Person;

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
 * @date 2020/4/11 23:57
 */
@WebServlet(name = "PersonListener", urlPatterns = "/PersonListener")
public class PersonListener extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("add".equals(method)){
            addPerson(request,response);
        }else if("remove".equals(method)){
            removePerson(request,response);
        }
    }

    private void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person p = new Person();
        p.setName("zs");
        p.setAge(12);
        HttpSession session = request.getSession();
        session.setAttribute("user",p);
        response.getWriter().write("写入session对象"+session.getId());
    }

    private void removePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.getWriter().write("移除session对象"+session.getAttribute("user"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
