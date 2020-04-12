package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:测试Spring MVC参数绑定的功能
 * @date 2020/2/27 1:09
 */
@Controller
@RequestMapping("/test01")
public class Test01Controller {

    @RequestMapping("/requestTest.do")
    public String requestTest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"---"+password);
        return "test/success";
    }

    @RequestMapping("/responseTest.do")
    public void responseTest(HttpServletResponse response) throws IOException {
        //以io流的方式直接进行页面的响应
        response.getWriter().print("hello");

        //以重定向的方式进行页面响应
        response.sendRedirect("/SSM-SpringMVC-Day04/npage/test/success.jsp");
    }

    @RequestMapping("/sessionTest.do")
    public String sessionTest(HttpServletRequest request, HttpSession session) {
        HttpSession requestSession = request.getSession();
        System.out.println(requestSession.getAttribute("sessionName"));
        System.out.println(session.getAttribute("sessionName"));

        return "test/success";
    }

    @RequestMapping("/formTest.do")
    public String formTest(String username, String password, int age, boolean sex) {

        System.out.println(username + "--" + password + "--" + age + "--" + sex);
        return "test/success";
    }

    @RequestMapping("modelTest.do")
    public String modelTest(UserInfo userInfo, String[] hobby, List<UserInfo> userInfoList) {
        System.out.println(userInfo);
        System.out.println(Arrays.toString(hobby));
        return "test/success";
    }

    @RequestMapping("/mapTest.do")
    public String mapTest(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return "test/success";
    }

    @RequestMapping("/paramTest.do")
    public String paramTest(@RequestParam(value = "username", required = false, defaultValue = "zhangsan") String name) {
        System.out.println(name);
        return "test/success";
    }

    @RequestMapping("/modelMapTest.do")
    public String modelMapTest(Model model,String username,String password) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("name", "zhangsan111");
        return "forward:/test01/modelMapForwardTest.do";
    }


    @RequestMapping("/modelMapForwardTest.do")
    public String modelMapForwardTest(ModelMap modelMap) {

        return "test/success";
    }

    @RequestMapping("/dateTest.do")
    public String dateTest(Date date,String name) {
        System.out.println(date);
        System.out.println(name);
        return "test/success";
    }
}
