package com.yckj.ssm.day02.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:通知类的定义
 * @date 2020/2/19 21:00
 */

public class AdviceInfo {
    /**
     * 前置通知执行方法的定义
     */
    public void before() {
        System.out.println("前置通知开始执行！");
        System.out.println(new Date());
    }

    /**
     * 后置通知执行方法的定义
     */
    public void after() {
        System.out.println("后置通知开始执行！");
    }

    /**
     * 后置成功通知执行方法的定义
     */
    public void afterReturning() {
        System.out.println("后置成功通知开始执行");
    }

    /**
     * 后置失败通知执行方法的定义
     */
    public void afterThrowing() {
        System.out.println("后置失败通知开始执行！");
    }

    /**
     * 环绕通知执行方法的定义
     */
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        //当前正在执行方法的对象的类名
        Class<?> clazz = proceedingJoinPoint.getTarget().getClass();
        String clazzName = clazz.getName();

        //当前正在执行的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();

        //当前正在执行方法的入参
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("["+new Date()+"]"
                + "[" + clazzName+"]"
                +"["+methodName+"]"
                +"["+ Arrays.toString(args)+"]");


        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知开始执行！");
    }
}
