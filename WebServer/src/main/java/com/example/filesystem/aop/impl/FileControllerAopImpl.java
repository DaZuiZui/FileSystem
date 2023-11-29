package com.example.filesystem.aop.impl;

import com.example.filesystem.aop.FileControllerAop;
import com.example.filesystem.pojo.bo.DeleteFileOrFolderBo;
import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.pojo.bo.SelectUpdateByToFileBo;
import com.example.filesystem.pojo.bo.UpdateFileOrFolderBo;
import com.example.filesystem.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    @Before("execution(* com.example.filesystem.controller.FileController.findOwnFile(..))")
    public void findOwnFile(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        FindOwnFileBo arg = (FindOwnFileBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param joinPoint
     */
    @Override
    @Before("execution(* com.example.filesystem.controller.FileController.deleteFileOrFolder(..))")
    public void deleteFileOrFolder(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        DeleteFileOrFolderBo arg = (DeleteFileOrFolderBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param joinPoint
     */
    @Override
    public void selectUpdateByToFile(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SelectUpdateByToFileBo arg = (SelectUpdateByToFileBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
    }

    /**
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param joinPoint
     */
    @Override
    public void updateFileOrFolder(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UpdateFileOrFolderBo arg = (UpdateFileOrFolderBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);
    }

}
