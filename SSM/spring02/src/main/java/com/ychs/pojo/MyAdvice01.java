package com.ychs.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:19
 */
@Aspect
public class MyAdvice01 {
    @Pointcut("execution(public * com.ychs.service..*ServiceImpl.*(..))")
    public void pc(){}
    @Before("MyAdvice01.pc()")
    public void before(){
        System.out.println("前置通知");
    }
    @AfterReturning("execution(public * com.ychs.service..*ServiceImpl.*(..))")
    public void afterReturing(){
        System.out.println("后置通知，出现异常不调用");
    }
    @Around("execution(public * com.ychs.service..*ServiceImpl.*(..))")
    public Object round(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("round前置通知");
        Object o = pjp.proceed();
        System.out.println("round后置通知");
        return o;
    }
    @AfterThrowing("execution(public * com.ychs.service..*ServiceImpl.*(..))")
    public void afterException(){
        System.out.println("出现异常了");
    }
    @After("execution(public * com.ychs.service..*ServiceImpl.*(..))")
    public void after(){
        System.out.println("后置通知，出现异常也调用");
    }
}
