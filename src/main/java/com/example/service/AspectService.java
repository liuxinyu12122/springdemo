package com.example.service;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-29 上午10:01
 */
@Aspect
public class AspectService {

    @Before("execution(* com.example.service.*Service.*(..))")
    public void aspect1(){
        System.out.print("haha");
        //storageTransactionManager.setNeedRollback(Boolean.TRUE);
    }

    @Before("execution(* com.example.demo.*Controller.*(..))")
    public void aspect2(){
        System.out.print("haha");
        //storageTransactionManager.setNeedRollback(Boolean.TRUE);
    }

    @AfterThrowing(pointcut = "execution(* com.example.service.*Service.*(..))", throwing = "ex")
    public void aspect3(Throwable ex) {
        //storageTransactionManager.setNeedRollback(Boolean.TRUE);
    }
}
