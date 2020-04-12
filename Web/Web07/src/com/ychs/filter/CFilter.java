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
 * @date 2020/4/12 17:04
 */

public class CFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CC初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CC开始CC");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("CC结束CC");
    }

    @Override
    public void destroy() {
        System.out.println("CC摧毁");
    }

}
