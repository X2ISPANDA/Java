package com.ychs.demo;

/**
 * @Description:学生的测试类
 * @Author Mingyu Xiong
 * @Date 2019/07/08 20:26
 */
public class TestStudent {
    public static void main(String[] args) {
        //创建对象
        Student xmy = new Student();
        System.out.println(xmy.sno);
        System.out.println(xmy.sname);
        //char初始化默认为\u0000 Unicode空格 本地ASCII编码显示乱码
        System.out.println(xmy.sex);
        System.out.println(xmy.age);
        System.out.println(xmy.isYear);
        System.out.println(xmy.avgScore);
        System.out.println(xmy.clazz);

        Student xff = new Student();
    }
}
