package com.example.filesystem.mapper;

import com.example.filesystem.pojo.File;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import com.example.filesystem.pojo.vo.UpdateFileOrFolderVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    File findOwnFile(FindOwnFileBo findOwnFileBo);

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param deleteFileOrFolderBo
     * @return
     */
    Long deleteFileOrFolder(DeleteFileOrFolderBo deleteFileOrFolderBo);

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param selectUpdateByToFileBo
     * @return
     */
    SelectUpdateByToFileVo selectUpdateByToFile(SelectUpdateByToFileBo selectUpdateByToFileBo);

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
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param updateFileOrFolderVo
     * @return
     */
    Long updateFileOrFolder(UpdateFileOrFolderVo updateFileOrFolderVo);
}
