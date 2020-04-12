package com.ychs.ssm.day04.util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingyu Xiong
 * @description:自定义异常处理器
 * @date 2020/3/21 0:38
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception exception) {
        ModelAndView modelAndView = new ModelAndView();

        if (exception instanceof BusiException) {
            modelAndView.setViewName("error/bussiError");
            modelAndView.addObject("exception", (BusiException)exception);
        } else {
            modelAndView.setViewName("error/unitedError");
        }
        return modelAndView;
    }
}
