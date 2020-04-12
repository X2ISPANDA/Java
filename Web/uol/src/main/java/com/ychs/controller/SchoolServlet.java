/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import com.ychs.bean.Page;
import com.ychs.bean.School;
import com.ychs.service.SchoolService;
import com.ychs.service.impl.SchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/22 10:53
 */
@WebServlet(name = "SchoolServlet", urlPatterns = "/school")
public class SchoolServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if ("querySchool".equals(method)) {
            querySchool(request, response);
        }
    }

    private void querySchool(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //作为条件查询传入
        String schoolName = request.getParameter("schoolName");
        String curPage = request.getParameter("curPage");
        int i = 1;
        if (!"".equals(curPage) && curPage != null) {
            i = Integer.parseInt(curPage);
        }
        SchoolService schoolService = new SchoolServiceImpl();
        School school = new School();
        school.setSchoolName(schoolName);
        school.setCurPage(i);
        Page<School> pageBean = schoolService.querySchool(school);
        request.setAttribute("pageInfo", pageBean);
        request.setAttribute("schoolName",schoolName);
        request.getRequestDispatcher("schoolQuery.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
