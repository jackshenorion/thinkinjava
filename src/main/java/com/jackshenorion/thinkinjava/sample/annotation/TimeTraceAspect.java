package com.jackshenorion.thinkinjava.sample.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TimeTraceAspect {

    @Before("@annotation(TimeTrace)")
    public void before(JoinPoint joinPoint){
        System.out.println("Before Hello!");
    }

    @After("execution(* *(..)) && @annotation(TimeTrace)")
    public void after(JoinPoint joinPoint){
        System.out.println("After Hello!");
    }

}
