package com.example.filesystem.mapper;

import com.example.filesystem.pojo.File;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    /**
     * @param createBy
     * @param filePath
     * @return
     * @author hln 2023-11-28
     * 显示自己的文件
     */
    List<File> findOwnFile(Long createBy, String filePath);

    /**
     * @return
     * @author hln 2023-11-28
     * 删除文件或文件夹
     */
    Long deleteFileOrFolder(String serverFilename);

    /**
     * @param serverFilename
     * @return
     * @author hln 2023-11-28
     * 查看修改文件的人
     */
    List<SelectUpdateByToFileVo> selectUpdateByToFile(String serverFilename);

    /**
     * @param updateFileOrFolderBo
     * @param lastName
     * @return
     * @author hln 2023-11-28
     * 重命名文件或文件夹
     */
//    Long updateFileOrFolder(UpdateFileOrFolderBo updateFileOrFolderBo, String lastName);

    /**
     * @author hln 2023-11-29
     *      获取file的Path
     * @param serverFilename
     * @return
     */
    String selectToGetPathFile(String serverFilename);

    /**
     * @author zzy 2023-11-30
     *      新建文件夹
     * @param insertFolderBo
     * @return
     */
    Long insertFolder(InsertFolderBo insertFolderBo);

    /**
     * @Auther Oh… Yeah!!! 2023-11-30
     *      上传文件
     * @param newFile
     * @return
     */
    public void addFile(File newFile);

    /**
     * @author zzy 2023-11-30
     *      移动文件或文件夹
     * @param moveFileOrFolderBo
     * @return
     */
    Long moveFileOrFolder(MoveFileOrFolderBo moveFileOrFolderBo);

    /**
     * @author hln 2023-12-05
     *      重命名文件或文件夹
     * @param serverFilename
     * @param updateName
     */
    void updateFileOrFolder(String serverFilename, String updateName);
}
