package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.DeleteFileOrFolderBo;
import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.pojo.vo.ResponseVo;

public interface FileService {

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    ResponseVo findOwnFile(FindOwnFileBo findOwnFileBo);

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param deleteFileOrFolderBo
     * @return
     */
    ResponseVo deleteFileOrFolder(DeleteFileOrFolderBo deleteFileOrFolderBo);
}
