/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/25 21:12
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();

        //System.out.println(path);
        // 从session里取员工工号信息
        String empId = (String) session.getAttribute("username");
        System.out.println(empId);
  /*创建类Constants.java，里面写的是无需过滤的页面
  for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
   if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
    chain.doFilter(servletRequest, servletResponse);
    return;
   }
  }*/
        // 登陆页面无需过滤
        if(path.indexOf("/userLogin.jsp") > -1){
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 判断如果没有取到员工信息,就跳转到登陆页面
        if (empId == null || "".equals(empId)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/uol_war_exploded/userLogin.jsp");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
