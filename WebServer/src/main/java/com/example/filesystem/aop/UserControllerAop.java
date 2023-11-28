package com.example.filesystem.aop;

import org.aspectj.lang.JoinPoint;

public interface UserControllerAop {


    /**
     * @author zhuxinyu 2023-11-28
     *   用户查询权限验证
     * @param joinPoint
     * @return
     */
    public String userSelect(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-11-28
     *  用户删除权限验证
     * @param joinPoint
     * @return
     */
    public String userDelete(JoinPoint joinPoint);

    /**
     * @author zhuxinyu 2023-11-28
     *  用户更新权限验证
     * @param joinPoint
     * @return
     */
    public String userUpdate(JoinPoint joinPoint);
}
