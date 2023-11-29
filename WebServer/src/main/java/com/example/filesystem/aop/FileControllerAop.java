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

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param joinPoint
     */
    void deleteFileOrFolder(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param joinPoint
     */
    void selectUpdateByToFile(JoinPoint joinPoint);

    /**
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param joinPoint
     */
    void updateFileOrFolder(JoinPoint joinPoint);

}
