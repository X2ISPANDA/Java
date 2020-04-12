package com.yckj.ssm.day02.services;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/19 17:41
 */
@Component
public class AServices {

    public void method01(int id,String name,int age) {
        //System.out.println("BServices"+new Date());
        System.out.println("AServices中的method01方法执行!");
    }

    public void method02() {
        //System.out.println(new Date());
        System.out.println("AServices中的method02方法执行!");
    }
}
