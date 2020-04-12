/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/9 15:41
 */
@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建cookie
        Cookie cookie = new Cookie("name", "wrx");
        Cookie cookie1 = new Cookie("sex", "women");
        //写到客户端
        response.addCookie(cookie);
        response.addCookie(cookie1);

        cookie.setPath(request.getContextPath()+"/aaa");
        cookie1.setPath(request.getContextPath()+"/bbb");

        /**
         * 设置cookie的有效期，这个值为一个整形值，单位为秒
         * 该值>0,表示将cookie存放到客户端的硬盘
         * 该值<0，与不设置效果相同，会将Cookie放到浏览器缓存
         * 该值=0,表示cookie一生成即马上失效
         */
        cookie.setMaxAge(60 * 60);//设置cookie的有效期为一小时


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
