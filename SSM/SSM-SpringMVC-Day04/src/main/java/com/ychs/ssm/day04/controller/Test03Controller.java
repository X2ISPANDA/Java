package com.ychs.ssm.day04.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:测试Spring MVC对数据回显的支持
 * @date 2020/3/14 1:03
 */
@Controller
@RequestMapping("/test03")
public class Test03Controller {

    @ModelAttribute("hobbyList")
    public List<String> getHobby() {
        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("读书");
        hobbyList.add("看报");
        hobbyList.add("喝茶");
        return hobbyList;
    }


    @RequestMapping(value = "/baseDataTest.do", method = RequestMethod.POST)
    public ModelAndView baseDataTest(String username, String password, int age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.addObject("age", age);
        modelAndView.addObject("message", "重名了");
        modelAndView.setViewName("test/test03");
        return modelAndView;
    }

    @RequestMapping("/pojoTest.do")
    public String pojoTest(UserInfo userInfo2) {
        System.out.println(userInfo2);
        return "test/test03";
    }

    @RequestMapping("/modelAttributeTest.do")
    public String modelAttributeTest() {
        return "test/test03";
    }
}
