/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/13 02:51
 */
public class Demo4 extends Demo3 {
    public static void main(String[] args) {
        new Demo3().f2();
        String d = "5";
        final  String s = d;
        d = "4";
        System.out.println(s);
        int x = 1;
        x++;
        System.out.println(x);

    }

}
