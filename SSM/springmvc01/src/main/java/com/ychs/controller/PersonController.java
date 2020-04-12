package com.ychs.controller;

import com.ychs.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
/*@RequestMapping(value = "/person")*/
public class PersonController {
    @RequestMapping(value = "/queryPerson",method = {RequestMethod.POST,RequestMethod.GET})
    public void queryPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("name:"+name);
        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person(1,"aaa",20,new Date());
        Person p2 = new Person(2,"bbb",21,new Date());
        Person p3 = new Person(3,"ccc",22,new Date());
        list.add(p1);
        list.add(p2);
        list.add(p3);
        request.setAttribute("list",list);
        request.getRequestDispatcher("../queryPerson.jsp").forward(request,response);
    }
    @RequestMapping(value = "/queryPerson2",method = {RequestMethod.POST,RequestMethod.GET})
    public String queryPerson2(HttpServletRequest request,ModelMap model){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name:"+name+",age:"+age);
        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person(1,"aaa",20,new Date());
        Person p2 = new Person(2,"bbb",21,new Date());
        Person p3 = new Person(3,"ccc",22,new Date());
        list.add(p1);
        list.add(p2);
        list.add(p3);
        model.addAttribute("list",list);
        return "forward:../queryPerson.jsp";
    }
    @RequestMapping(value = "/queryPerson3")
    public void queryPerson3(@RequestParam(value = "pname",required = true,defaultValue = "lisi") String name, int age){
        System.out.println("name:"+name+"age:"+age);
    }
    @RequestMapping(value = "/queryPerson4")
    public void queryPerson4(Person p){
        //3,王五,21,Wed Jan 08 15:55:01 CST 2020
        System.out.println(p.getId()+","+p.getName()+","+p.getAge()+","+p.getCurDate());
    }

    /**
     * 提交的方式是post提交，需要在web.xml中设置编码
     * @param p
     */
    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public String addPerson(@ModelAttribute(value = "p") Person p){
        System.out.println(p.getName()+","+p.getAge()+","+p.getCurDate());
        return "addPerson";
    }
    /**
     * 输入的参数是数组
     */
    @RequestMapping(value = "/addPerson1",method = RequestMethod.POST)
    public void addPerson1(Person p,@RequestParam(value = "hobby") String[] arr){
        System.out.println(p.getName()+","+ Arrays.toString(arr));
    }
    @RequestMapping(value = "/addPerson2")
    public void addPerson2(@RequestParam(value = "hobby") List<String> list){
        System.out.println(list);
    }



}
