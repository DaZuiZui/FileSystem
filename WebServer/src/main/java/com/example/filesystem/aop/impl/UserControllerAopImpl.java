package com.example.filesystem.aop.impl;

import com.example.filesystem.aop.UserControllerAop;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerAopImpl implements UserControllerAop {
    @Autowired
    private SystemService systemService;

    /**
     * @author zhuxinyu 2023-11-28
     *      用户查询权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userSelect(..))")
    public String userSelect(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserSelectBo userSelectBo = (UserSelectBo) args[0];
        String token = userSelectBo.getToken();
        systemService.isAdmin(token , 1);

        return null;
    }

    /**
     * @author zhuxinyu 2023-11-28
     *   用户删除权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userDelete(..))")
    public String userDelete(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserDeleteBo userDeleteBo = (UserDeleteBo) args[0];
        String token = userDeleteBo.getToken();
        systemService.isAdmin(token , 1);
        return null;
    }

    /**
     * @author zhuxinyu 2023-11-28
     *      用户更新权限验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.userUpdate(..))")
    public String userUpdate(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserUpdateBo userUpdateBo = (UserUpdateBo) args[0];
        String token = userUpdateBo.getToken();
        systemService.isAdmin(token , 0);
        return null;
    }

    /**
     * @author zhuxinyu 2023-12-01
     *      返回所有用户的基础信息验证
     * @param joinPoint
     * @return
     */
    @Override
    @Before("execution(* com.example.filesystem.controller.UserController.findAllUser(..))")
    public String userFindAll(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserFindAllBo userFindAllBo = (UserFindAllBo) args[0];
        String token = userFindAllBo.getToken();
        systemService.isAdmin(token , 1);
        return null;
    }

    /**
     * @author zhuxinyu 2023-12-02
     *      分页查询
     * @param joinPoint
     * @return
     */
    @Override
    public String userPagingToGetData(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserPagingToGetDataBo userPagingToGetDataBo = (UserPagingToGetDataBo) args[0];
        String token = userPagingToGetDataBo.getToken();
        systemService.auth(token);
        return null;
    }

}
