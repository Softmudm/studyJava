package com.sz.softmudm.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class AopLog {
    //获取logger对象，传入的是本类的Class对象
    private Logger logger = Logger.getLogger(AopLog.class);
    //定义调用方法前的操作,名字随便取，在什么时候调用主要要在applicationContext.xml中配置
    public void doBefore(JoinPoint joinPoint){
        logger.info("你正在调用的方法名是："+joinPoint.getSignature().getName());
        logger.info("你正在调用的方法有参数有："+ Arrays.toString(joinPoint.getArgs()));
    }
    //定义调用方法后的操作
    public void doAfter(JoinPoint joinPoint){
        logger.info("=======================已经完成调用！"+joinPoint.getSignature().getName()+"===============");
    }
    //定义返回 值时的操作
    public void doReturn(JoinPoint joinPoint){
        logger.info("doReturn被执行了！！！如果有异常，不执行");
    }
    //定义有异常时的操作
    public void doThrow(JoinPoint joinPoint){
        logger.info("doThrow被执行了！！！如果有异常就执行，否则就不执行！");
    }
    //定义在执行方法前后的操作，一般用来计时
    public Object doAround(ProceedingJoinPoint joinPoint){
        Object obj  = null;
        long start  = System.currentTimeMillis();
        try {
            obj = joinPoint.proceed();   //正在调用执行的方法；
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("此方法执行时间为(单位：毫秒)"+(end-start)+",执行的结果是:"+obj.toString());
        return obj;
    }
}
