package com.example.filesystem.aop.impl;

import com.example.filesystem.aop.UserControllerAop;
import com.example.filesystem.pojo.bo.UserDeleteBo;
import com.example.filesystem.pojo.bo.UserSelectBo;
import com.example.filesystem.pojo.bo.UserUpdateBo;
import com.example.filesystem.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerImlpl implements UserControllerAop {
    @Autowired
    private SystemService systemService;

    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userSelect(..))")
    public String userSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSelectBo userSelectBo = (UserSelectBo) args[0];
        String token = userSelectBo.getToken();
        systemService.auth(token);

        return null;
    }

    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userDelete(..))")
    public String userDelete(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserDeleteBo userDeleteBo = (UserDeleteBo) args[0];
        String token = userDeleteBo.getToken();
        systemService.auth(token);
        return null;
    }

    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userUpdate(..))")
    public String userUpdate(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserUpdateBo userUpdateBo = (UserUpdateBo) args[0];
        String token = userUpdateBo.getToken();
        systemService.auth(token);
        return null;
    }
}
