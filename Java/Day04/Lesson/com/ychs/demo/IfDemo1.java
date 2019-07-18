package com.ychs.demo;

import java.util.Scanner;

/**
 * @Description:if语句demonstration
 * @Author Mingyu Xiong
 * @Date 2019/07/10 09:12
 */
public class IfDemo1 {
    public static void main(String[] args) {
        int i=3;

        //if语句中只有一句话时可以省略大括号，但是不能声明变量
        if(i>3) {
            System.out.println("i=" + i);}

        //if(i==3) int j=3;

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个数：");
        int b = sc.nextInt();

        if (a > b) {
            System.out.println(a + ">" + b);
        }else{
            System.out.println(a + "<" + b);
        }

    }
}
