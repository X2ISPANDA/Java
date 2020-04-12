package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/26 17:44
 */
@Controller
@RequestMapping("User")
public class UserController {

    @RequestMapping("/addUser.do")
    public String addUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("添加用户功能!");
        return "user/addUser";
    }

    @RequestMapping("/queryUser.do")
    public String queryUser() {
        System.out.println("查询用户功能!");
        return "/index.jsp";
    }


}
