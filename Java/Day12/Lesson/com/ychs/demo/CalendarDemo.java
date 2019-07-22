/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Mingyu Xiong
 * @description:Calendar类的使用
 * @date 2019/07/22 15:03
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //Calendar是抽象类,创建它的子类对象
        Calendar calendar = new GregorianCalendar();
        //还可以通过它的getInstance方法获取实例
        Calendar calendar1 = Calendar.getInstance();

        System.out.println(Calendar.YEAR);
        System.out.println(Calendar.MONTH);
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(Calendar.DATE);
        System.out.println(Calendar.HOUR);
        System.out.println(Calendar.MINUTE);
        System.out.println(Calendar.SECOND);
        System.out.println(Calendar.MILLISECOND);
        System.out.println("================");
        System.out.println(calendar.get(Calendar.YEAR));
    }
}
