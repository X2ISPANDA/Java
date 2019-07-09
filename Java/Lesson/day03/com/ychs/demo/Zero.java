package com.ychs.demo;

/**
 * @Description:
 * @Author Mingyu Xiong
 * @Date 2019/07/09 09:58
 */
public class Zero {
    public static void main(String[] args) {
        //编译不报错运行报错
        //System.out.println(3 / 0);

        //发生转型，Infinity正无穷大
        System.out.println(3.0 / 0);

        System.out.println(2 / -3);
        //-Infinity
        System.out.println(-3.0 / 0);
        //NaN
        System.out.println(0 / 0.0);

        System.out.println(0.5 % 0.2);


//        int a = 1;
//        a++;//++a
//
//        //b = a,a=a+1,b=2,a=3
//        int b = a++;
//        //a=a+1 b=a
//        b = ++a;


        int a = 4;
        int b=++a;
        int c = b++ + --a - --b + ++b;
        System.out.println(a+" "+" "+b+" "+c);
        //5+4-5+6

        int d = 100;
        int e = 50;
        boolean f = ((d++ + ++e) > 155) && d > 0 || e < 30 & (e++ - --d) < 120;
        System.out.println(d+" "+e+" "+f);
    }
}
