package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.util.BusiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Mingyu Xiong
 * @description:测试统一异常处理功能的控制器
 * @date 2020/3/20 17:50
 */
@Controller
@RequestMapping("/test06")
public class Test06Controller {

    @RequestMapping("/defaultExpTest.do")
    public ModelAndView defaultExpTest(String username) {
        ModelAndView modelAndView = new ModelAndView("/test/success");
        int num = 1 / 0;
        return modelAndView;
    }

    @RequestMapping("/busiExpTest.do")
    public ModelAndView busiExpTest(int age) throws BusiException {
        if (age < 0 || age > 180) {
            throw new BusiException("10001", "你输入的年龄不合法！");
        }
        ModelAndView modelAndView = new ModelAndView("/test/success");

        return modelAndView;
    }
}
