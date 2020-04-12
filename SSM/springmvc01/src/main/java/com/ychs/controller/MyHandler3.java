package com.ychs.controller;

import com.ychs.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/myHandler")
public class MyHandler3 {
    @RequestMapping(value = "/queryStu",method = RequestMethod.POST)
    public ModelAndView queryStu(){
        System.out.println("进入....");
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
