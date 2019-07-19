/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/18 17:37
 */
public class DuotaiTest {
    public static void main(String[] args) {
        SonDemo son = new SonDemo();
        son.setName("张三");
        son.eat();
        FatherDemo father = new FatherDemo();
        father.setName("张爸");
        father.eat();
        System.out.println("===========");
        FatherDemo son2 = new SonDemo();
        son2.setName("张四");
        son2.eat();
//		son2.eat();编译不通过
        System.out.println(son2.i);

        //报类型异常
//		SonDemo son3 = (SonDemo) father;
//		son3.eat();
    }
}
