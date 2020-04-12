package com.yckj.ssm.day02.services;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/19 17:41
 */
@Component
public class BServices {

    public void method01() {
        //System.out.println(new Date());
        System.out.println("BServices中的method01方法执行!");
    }

    public void method02() {
       //System.out.println(new Date());
        System.out.println("BServices中的method02方法执行!");
    }
}
