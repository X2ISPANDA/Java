package com.ychs.demo;

/**
 * @Description:person的测试类
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:24
 */
public class TestPerson {
    public static void main(String[] args) {
        //创建了这个模板的对象zs
        Person p1 = new Person();
        p1.name = "肖浩锋";
        p1.height = 127;
        p1.weight = 130;
        p1.age = 21;
        p1.idCard = 1607094150L;
        p1.salary = 0f;
        p1.yearSalary = 0.0001;
        p1.sex = '女';
        p1.isYear = true;
        System.out.println(p1.showPerson());

    }
}
