/*
 * Copyright (c) 2019.
 * All Rights Reserved By Mingyu Xiong
 */

package com.ychs.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/22 15:25
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //date-->String
        String string = dateFormat.format(new Date());
        System.out.println(string);

        //String-->date
        Date date = dateFormat.parse(string);
        System.out.println(date);
    }
}
