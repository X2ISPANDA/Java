package com.ychs.ssm.day07.controller;

import com.ychs.ssm.day07.model.UserInfo;
import com.ychs.ssm.day07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:用户管理功能控制器
 * @date 2020/3/25 14:04
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户功能默认处理实体
     */
    @Autowired
    private UserService userService;

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    @RequestMapping("/queryUserByName.do")
    public ModelAndView queryUserByName(String username) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.queryUserByName(username);
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user/queryUser");
        return modelAndView;
    }

    /**
     * 多条件动态查询用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping("/queryUserMultiple.do")
    public ModelAndView queryUserMultiple(UserInfo userInfo) {
        List<UserInfo> userInfoList = userService.queryUserMultiple(userInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfoList", userInfoList);
        modelAndView.setViewName("user/queryUserList");
        return modelAndView;
    }
}
