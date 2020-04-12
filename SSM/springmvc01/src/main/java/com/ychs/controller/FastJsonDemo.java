package com.ychs.controller;

import com.ychs.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/fastJsonDemo")
public class FastJsonDemo {

    @RequestMapping(value = "/fun",method = RequestMethod.POST)
    public void function(String name,String age,HttpServletResponse response) throws IOException {
        System.out.println(name+","+age);
        String s = "{\"name\":\""+name+"\",\"age\":"+age+"}";
        response.getWriter().write(s);
    }
    @RequestMapping(value = "/fun1",method = RequestMethod.POST)
    public @ResponseBody Person function1(String name,String age,HttpServletResponse response) throws IOException {
        Person p = new Person();
        p.setName(name);
        p.setAge(Integer.parseInt(age));
        return p;
    }
    @RequestMapping(value = "/fun2",method = RequestMethod.POST)
    @ResponseBody
    public Person function2(@RequestBody Person p, HttpServletResponse response) throws IOException {
        /*Person p = new Person();
        p.setName(name);
        p.setAge(Integer.parseInt(age));*/
        System.out.println(p.getName()+","+p.getAge());
        return p;
    }


}
