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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/11/17 14:25
 */
@WebServlet(name = "RequestServlet",urlPatterns = "/requestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request是域对象，通过浏览器发送的所有的信息都可以在request中获取到
        //http://localhost:8080/web02/requestServlet?username=%E5%BC%A0%E4%B8%89&password=123456&hobby=play&hobby=dance
        //作用：获取浏览器发送过来的数据
        String scheme = request.getScheme();
        System.out.println(scheme);
        String serverName = request.getServerName();
        System.out.println("serverName="+serverName);
        int serverPort = request.getServerPort();
        System.out.println("serverPort="+serverPort);
        //重要
        String contextPath = request.getContextPath();
        System.out.println("contextPath="+contextPath);
        String servletPath = request.getServletPath();
        System.out.println("servletPath="+servletPath);
        String queryString = request.getQueryString();
        System.out.println("queryString="+queryString);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL="+requestURL);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI="+requestURI);

        System.out.println("==========");
        String method = request.getMethod();
        System.out.println("method="+method);
        //枚举类型
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
//            System.out.println(request.getHeader(headerNames.nextElement()));
        }
        //String[] getParameterValues(String key):通过一个key获取多个值
        String[] hobby = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map.keySet());
        for (String key:map.keySet()){
            String[] value = map.get(key);
            for (String s : value) {
                System.out.println(key+","+s);
            }

        }

    }

}
