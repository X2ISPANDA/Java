package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingyu Xiong
 * @description:测试控制器，测试SpringMVC原始的使用方式
 * @date 2020/2/23 20:56
 */
public class TestController implements Controller {
    private TestService testService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        testService.test();
        return null;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }
}
