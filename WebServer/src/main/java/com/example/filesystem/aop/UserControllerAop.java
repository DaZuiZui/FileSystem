package com.example.filesystem.aop;

import org.aspectj.lang.JoinPoint;

public interface UserControllerAop {



    public String userSelect(JoinPoint joinPoint);

    public String userDelete(JoinPoint joinPoint);

    public String userUpdate(JoinPoint joinPoint);
}
