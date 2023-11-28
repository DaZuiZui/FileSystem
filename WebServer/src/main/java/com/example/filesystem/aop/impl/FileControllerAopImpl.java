package com.example.filesystem.aop.impl;

import com.example.filesystem.aop.FileControllerAop;
import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hln 2023-11-28
 *      功能鉴权
 */
@Component
@Aspect
public class FileControllerAopImpl implements FileControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param joinPoint
     */
    @Override
    public void findOwnFile(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        FindOwnFileBo arg = (FindOwnFileBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,1);
    }

}
