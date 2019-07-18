/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

import com.ychs.bean.Car;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 22:46
 */
public class TestCar {
    public static void main(String[] args) {
        Car qq = new Car();
        qq.setBrand("qq");
        qq.setCarNum("晋A99999");
        qq.setColor("red");
        System.out.println(qq);
        Car qq2 = new Car();
        qq2.setBrand("qq");
        qq2.setCarNum("晋A99999");
        qq2.setColor("red");
        System.out.println(qq2);
        /*
         * if(qq.equals(qq2)) { System.out.println("一样"); }else {
         * System.out.println("不一样"); }
         */
        if(qq.getBrand().equals(qq2.getBrand())
                &&qq.getCarNum().equals(qq2.getCarNum())
                &&qq.getColor().equals(qq2.getColor())){
            System.out.println("一样");
        } else {
            System.out.println("不一样");
        }

    }
}
