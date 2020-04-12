package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mingyu Xiong
 * @description:Spring MVC对RESTful风格的支持
 * @date 2020/3/16 23:29
 */
@Controller
@RequestMapping("/test05")
public class Test05Controller {

    @RequestMapping(value = "/restTest", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo restTest(@RequestBody UserInfo userInfo) {
        return userInfo;
    }

    @RequestMapping(value = "/restGetTest/{username}/{password}",method = RequestMethod.GET)
    public @ResponseBody UserInfo restGetTest(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(password);
        userInfo.setUsername(username);
        return userInfo;
    }
}
