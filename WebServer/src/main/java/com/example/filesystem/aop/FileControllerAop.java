package com.example.filesystem.aop;

import org.aspectj.lang.JoinPoint;

/**
 *  文件鉴权接口
 */
public interface FileControllerAop {

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param joinPoint
     */
    void findOwnFile(JoinPoint joinPoint);

}
