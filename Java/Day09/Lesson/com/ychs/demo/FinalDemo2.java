/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/17 09:30
 */
public class FinalDemo2 {
    //不能被重写
    public final void f() {
        System.out.println("nishishabi");
    }

    public void f2() {
        System.out.println("nishihanpi");
    }
}

class FinalDemo3 extends FinalDemo2 {

}
