package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    /**
     * @param filePath
     * @param token
     * @return
     * @author hln 2023-11-28
     * 显示自己的文件
     */
    String findOwnFile(String filePath, String token);

    /**
     * @param serverFilename
     * @param substring
     * @return
     * @author hln 2023-11-28
     * 删除文件或文件夹
     */
    String deleteFileOrFolder(String serverFilename, String substring);

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

    /**
     * @author hln 2023-12-05
     *      查看修改文件的人
     * @param serverFilename
     * @param token
     * @return
     */
    String selectUpdateByToFile(String serverFilename, String token);

    /**
     * @author hln 2023-12-05
     *      重命名文件或文件夹
     * @param serverFilename
     * @param updateName
     * @param token
     * @return
     */
    String updateFileOrFolder(String serverFilename, String updateName, String token);


//    /**
//     * @author Oh...Yeah!!! 2023-11-13
//     *    文件下载
//     * @param
//     * @param
//     * @return String.class
//     */
//    public ResponseVo download(String reteFilePath, String loFilePath);
}
