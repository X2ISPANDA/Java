package com.ychs.controller;

import com.ychs.bean.Student;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MyHandler implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进入。。。");
        List<Student> list = new ArrayList<Student>();
        Student stu1 = new Student(1,"zs");
        Student stu2 = new Student(2,"ls");
        Student stu3 = new Student(3,"ww");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("demo01");
        return mv;
    }
}
