package com.ychs.pojo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:50
 */
public class CreatePerson {

    public static Person createP(){
        System.out.println("静态工厂的方式创建");
        return new Person();
    }
    public Person createP2(){
        System.out.println("实例工厂方式创建");
        return new Person();
    }
}
