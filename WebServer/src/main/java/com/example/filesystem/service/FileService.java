package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    /**
     * @param substring
     * @return
     * @author hln 2023-11-28
     * 显示自己的文件
     */
    String findOwnFile(String substring);

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
     * @author Oh...Yeah!!! 2023-11-13
     *    文件上传
     * @param token
     * @param file
     * @return String.class
     */
    public String fileUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException;


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


//    /**
//     * @author Oh...Yeah!!! 2023-11-13
//     *    文件下载
//     * @param
//     * @param
//     * @return String.class
//     */
//    public ResponseVo download(String reteFilePath, String loFilePath);
}
