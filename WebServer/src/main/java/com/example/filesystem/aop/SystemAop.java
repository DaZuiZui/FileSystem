package com.example.filesystem.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public interface SystemAop {
    /**
     * @auhtor bryan yang
     * 清理ThreadLocal 防止内存泄漏
     * @param joinpoint
     * @throws Exception
     */
    public void removeAllThreadLocal(JoinPoint joinpoint) throws Exception;
}