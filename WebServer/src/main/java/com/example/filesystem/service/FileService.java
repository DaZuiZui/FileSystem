package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;

import javax.servlet.http.HttpServletResponse;

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

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param selectUpdateByToFileBo
     * @return
     */
    ResponseVo selectUpdateByToFile(SelectUpdateByToFileBo selectUpdateByToFileBo);

    /**
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param updateFileOrFolderBo
     * @return
     */
    ResponseVo updateFileOrFolder(UpdateFileOrFolderBo updateFileOrFolderBo);

    /**
     * @author hln 2023-11-29
     *      下载文件功能
     * @param downloadFileBo
     * @return
     */
    ResponseVo downloadFile(DownloadFileBo downloadFileBo, HttpServletResponse response);

    /**
     * @author zzy 2023-11-30
     *      新建文件夹
     * @param insertFolderBo
     * @return
     */
    ResponseVo insertFolder(InsertFolderBo insertFolderBo);

    /**
     * @author zzy 2023-11-30
     *      移动文件或文件夹
     * @param moveFileOrFolderBo
     * @return
     */
    ResponseVo moveFileOrFolder(MoveFileOrFolderBo moveFileOrFolderBo);
}
