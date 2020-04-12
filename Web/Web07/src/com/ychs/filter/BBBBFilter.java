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
 * @date 2020/4/12 16:58
 */
public class BBBBFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("B初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("BB开始BB");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("BB结束BB");
    }

    @Override
    public void destroy() {
        System.out.println("B摧毁");
    }
}
