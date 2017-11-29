package com.sky.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

//    @Before("execution(public  * com.sky.girl.controller.GirlController.*(..))")
//    public  void log(){
//        System.out.println(1111111);
//    }
//
//    @After("execution(public  * com.sky.girl.controller.GirlController.*(..))")
//    public  void log2(){
//        System.out.println(22222);
//    }
    Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public  * com.sky.girl.controller.GirlController.*(..))")
    public  void logPoint(){
    }
    @Before("logPoint()")
    public  void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore");
        logger.info("1111");

        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("logPoint()")
    public  void logAfter(){
        System.out.println("logAfter");

        logger.info("2222");
    }
    @AfterReturning(pointcut = "logPoint()",returning = "object")
    public void  doAfterReturning(Object object)   {
        logger.info("response={}",object);
    }
}
