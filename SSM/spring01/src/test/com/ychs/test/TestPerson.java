package com.ychs.test;

import com.ychs.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:54
 */
public class TestPerson {

    @Test
    public void testPerson(){
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("ac1.xml");
        /*Person p = (Person) ac.getBean("person1");
        System.out.println(p);
        Person p1 = (Person) ac.getBean("person1");
        System.out.println(p1);*/
        ac.close();
    }
    @Test
    public void createP(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) ac.getBean("createPerson");
        Person p2 = (Person) ac.getBean("createPerson");
        System.out.println(p);
        System.out.println(p2);

    }
    @Test
    public void createP2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) ac.getBean("p");
        Person p2 = (Person) ac.getBean("p");
        System.out.println(p);
        System.out.println(p2);

    }
    @Test
    public void testVal(){
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p = (Person) ac.getBean("p");
        System.out.println(p.getId()+","+p.getName()+","+p.getAge());
        System.out.println(p.getPhone().getId()+","+p.getPhone().getType());
    }
}
