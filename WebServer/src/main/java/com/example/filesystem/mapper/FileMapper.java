package com.example.filesystem.mapper;

import com.example.filesystem.pojo.FileS;
import com.example.filesystem.pojo.bo.DeleteFileOrFolderBo;
import com.example.filesystem.pojo.bo.FindOwnFileBo;
import com.example.filesystem.pojo.bo.SelectUpdateByToFileBo;
import com.example.filesystem.pojo.bo.UpdateFileOrFolderBo;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    FileS findOwnFile(FindOwnFileBo findOwnFileBo);

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
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param updateFileOrFolderBo
     * @return
     */
    Long updateFileOrFolder(UpdateFileOrFolderBo updateFileOrFolderBo);

    /**
     * @author hln 2023-11-29
     *      获取file的Path
     * @param serverFilename
     * @return
     */
    String selectToGetPathFile(String serverFilename);
}
