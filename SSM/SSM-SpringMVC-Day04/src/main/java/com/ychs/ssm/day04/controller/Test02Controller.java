package com.ychs.ssm.day04.controller;

import com.ychs.ssm.day04.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:Spring MVC方法出参的测试
 * @date 2020/3/12 12:58
 */
@Controller
@RequestMapping("/test02")
public class Test02Controller {

    @RequestMapping("/voidTest.do")
    public void voidTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*使用request对象进行请求转发时,Spring MVC的视图解析器不生效,所以转发路径要写完整的服务端相对路径*/
        //request.getRequestDispatcher("/npage/test/success.jsp").forward(request,response);
        //request.getRequestDispatcher("/test/success.jsp").forward(request,response);

        /*使用重定向response对象进行重定向响应，需要写客户端相对路径*/
        //response.sendRedirect("/SSM-SpringMVC-Day04/npage/test/success.jsp");

        /**
         * 使用response对象的字符流进行响应，支持ajax的请求响应。
         */
        response.getWriter().print("{'name':'zhangsan','age':18}");
    }

    @RequestMapping("/stringTest.do")
    public String stringTest(String username) {
        System.out.println(username);
        /**
         * 直接返回一个字符串，该字符串代表Spring MVC视图解析器解析的路径。默认使用的是请求转发操作。
         */
        //return "test/success";

        /**
         * 当字符串以forward:开头，代表当前的响应方式为请求转发方式，
         * 冒号后面的路径为请求转发完整的服务端相对路径，视图解析器不进行解析。
         */
        //return "forward:test/success";
        //return "forward:/npage/test/success.jsp";

        /**
         * 当返回字符串以redirect:开头的时候，代表当前请求以重定向的方式进行相应，
         * 重定向本质上是客户端请求，需要编写项目的项目名，
         * 但是Spring MVC默认帮我们编写了项目名，所以不需要写项目名称，
         * 类似于服务端路径。
         */
        //return "redirect:/npage/test/success.jsp";
        return "redirect:/npage/test/success.jsp";
    }

    @RequestMapping("/mvTest.do")
    public ModelAndView mvTest(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        //addObject方法在request域中添加属性
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.addObject("name", "zhangsan111");
        //setViewName方法设置视图解析器的转发路径
        modelAndView.setViewName("test/success");
        return modelAndView;
    }

    @RequestMapping("/pojoTest.do")
    public UserInfo pojoTest() {
        return new UserInfo();
    }

    @RequestMapping("/forwardController.do")
    public ModelAndView forwardController(HttpServletRequest request,String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        modelAndView.addObject("name", "zhangsan111");
        /**
         * ModelAndView类型设置视图名称时，如果字符串单签没有指定forward：或者redirect：，默认进行视图解析器的操作；若存在则进行转发或者重定向操作，并且支持转发重定向到另一个Controller方法当中去。
         */
        modelAndView.setViewName("forward:/test02/forwardJSP.do");
        System.out.println(request);
        return modelAndView;
    }

    @RequestMapping("/forwardJSP.do")
    public ModelAndView forwardJSP(HttpServletRequest request) {
        System.out.println(request);
        //通过有参构造函数也能实现请求转发的操作
        return new ModelAndView("test/success");
    }
}
