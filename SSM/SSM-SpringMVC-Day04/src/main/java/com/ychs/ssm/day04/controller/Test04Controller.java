package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:Spring MVC处理Ajax请求的相关测试
 * @date 2020/3/16 13:50
 */
@Controller
@RequestMapping("/test04")
public class Test04Controller {

    @RequestMapping("/ajaxString.do")
    public void ajaxString(String username, String password, HttpServletResponse response) throws IOException {
        System.out.println(username + "--" + password);
        response.getWriter().print("{\"username\":\""+username+"\",\"password\":\""+password+"\"}");
    }

    @RequestMapping("ajaxJackson.do")
    public @ResponseBody UserInfo ajaxJackson(UserInfo userInfo) {
        System.out.println(userInfo);
        return userInfo;
    }

    @RequestMapping("/ajaxInJSON.do")
    public @ResponseBody UserInfo ajaxInJSON(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        return userInfo;
    }
}
