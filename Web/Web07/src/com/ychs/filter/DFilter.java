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
 * @date 2020/4/12 17:05
 */
public class DFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DD初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DD开始DD");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("DD结束DD");
    }

    @Override
    public void destroy() {
        System.out.println("DD摧毁");
    }
}
