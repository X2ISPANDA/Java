package com.yckj.ssm.day02.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Mingyu Xiong
 * @description:以注解的方式来实现AOP切面编程
 * @date 2020/2/20 18:46
 */
@Aspect
@Component
public class AdviceInfoAnno {

    @Pointcut("execution(* com.yckj.ssm.day02.services.*.*(..))")
    public void test() {

    }

    /**
     * 前置通知执行方法的定义
     */
    @Before(value = "test()")
    public void before() {
        System.out.println("前置通知开始执行！");
        System.out.println(new Date());
    }

    /**
     * 后置通知执行方法的定义
     */
    @After(value = "test()")
    public void after() {
        System.out.println("后置通知开始执行！");
    }

    /**
     * 后置成功通知执行方法的定义
     */
    @AfterReturning(value = "test()")
    public void afterReturning() {
        System.out.println("后置成功通知开始执行");
    }

    /**
     * 后置失败通知执行方法的定义
     */
    @AfterThrowing(value = "test()")
    public void afterThrowing() {
        System.out.println("后置失败通知开始执行！");
    }

    /**
     * 环绕通知执行方法的定义
     */
    @Around(value = "test()")
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
    }
}
