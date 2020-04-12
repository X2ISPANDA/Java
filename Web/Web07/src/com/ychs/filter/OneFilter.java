/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/11 19:17
 */
public class OneFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    /**
     * 图片少儿不宜，必须18岁以上才可以访问
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //1.从拦截的请求对象身上获得来访者的年龄
        String age = servletRequest.getParameter("age");

        //2.根据年龄，判断当前请求的合法性
        if (Integer.valueOf(age) >= 18) {//合法请求，放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {//终止本次请求
            servletResponse.setCharacterEncoding("GBK");
            servletResponse.getWriter().write("过两年再来");

        }
    }
}
