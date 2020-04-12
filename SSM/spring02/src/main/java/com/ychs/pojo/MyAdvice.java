package com.ychs.pojo;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:16
 */
public class MyAdvice {
    public void before(){
        System.out.println("前置通知");
    }
    public void afterReturing(){
        System.out.println("后置通知，出现异常不调用");
    }
    public Object round(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("round前置通知");
        Object o = pjp.proceed();
        System.out.println("round后置通知");
        return o;
    }
    public void afterException(){
        System.out.println("出现异常了");
    }
    public void after(){
        System.out.println("后置通知，出现异常也调用");
    }
}
