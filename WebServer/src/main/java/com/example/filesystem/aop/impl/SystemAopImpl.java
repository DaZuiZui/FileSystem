package com.example.filesystem.aop.impl;

import com.example.filesystem.aop.SystemAop;
import com.example.filesystem.util.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemAopImpl implements SystemAop {
    /**
     * @auhtor zhuxinyu 2023-11-28
     * 清理ThreadLocal 防止内存泄漏
     * @param joinpoint
     * @throws Exception
     */
    @Override
    @After("execution(* com.example.filesystem.controller.*.*(..))")
    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception {
        ThreadLocalUtil.mapThreadLocalOfJWT.remove();
        ThreadLocalUtil.mapThreadLocal.remove();
        ThreadLocalUtil.DataOfThreadLocal.remove();

    }
}
