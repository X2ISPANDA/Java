/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import com.ychs.bean.Dept;
import com.ychs.bean.School;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/21 16:47
 */
@WebServlet(name = "LianDongServlet", urlPatterns = "/ldservlet")
public class LianDongServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String schoolId = request.getParameter("schoolId");
        int id = 0;
        if (!"".equals(schoolId)) {
            id = Integer.parseInt(schoolId);
        }
        List list = new ArrayList();
        if (id == 1) {
            Dept dept = new Dept(1, "计算机");
            Dept dept1 = new Dept(2, "中文");
            Dept dept2 = new Dept(3, "物联网");
            list.add(dept);
            list.add(dept1);
            list.add(dept2);
        } else if (id == 2) {
            Dept dept = new Dept(1, "水货");
            Dept dept1 = new Dept(2, "狠货");
            Dept dept2 = new Dept(3, "硬货");
            list.add(dept);
            list.add(dept1);
            list.add(dept2);
        } else if (id == 3) {
            Dept dept = new Dept(1, "经管");
            Dept dept1 = new Dept(2, "物流");
            Dept dept2 = new Dept(3, "算数");
            list.add(dept);
            list.add(dept1);
            list.add(dept2);
        } else if (id == 4) {
            Dept dept = new Dept(1, "打桩机");
            Dept dept1 = new Dept(2, "拖拉机");
            Dept dept2 = new Dept(2, "挖掘机");
            list.add(dept);
            list.add(dept1);
            list.add(dept2);
        }
        response.getWriter().write(JSONArray.fromObject(list).toString());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List list = new ArrayList();
        School s = new School();
        School s1 = new School();
        School s2 = new School();
        School s3 = new School();
        s.setId(1);
        s.setName("中北大学");
        s1.setId(2);
        s1.setName("北京大学");
        s2.setId(3);
        s2.setName("清华大学");
        s3.setName("南京大学");
        s3.setId(4);
        list.add(s);
        list.add(s2);
        list.add(s1);
        list.add(s3);
        request.setAttribute("list", list);
        request.getRequestDispatcher("联动.jsp").forward(request, response);
    }
}
