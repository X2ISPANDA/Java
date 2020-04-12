package com.ychs.controller;

import com.ychs.bean.Student;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyHandler2 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入。。。");
        List<Student> list = new ArrayList<Student>();
        Student stu1 = new Student(1,"zs");
        Student stu2 = new Student(2,"ls");
        Student stu3 = new Student(3,"ww");
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        request.setAttribute("list",list);
        request.getRequestDispatcher("demo01.jsp").forward(request,response);
    }
}
