package com.example.filesystem.service.impl;

import com.example.filesystem.mapper.FileMapper;
import com.example.filesystem.pojo.FileS;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    @Override
    public ResponseVo findOwnFile(FindOwnFileBo findOwnFileBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败",null,"0x501");
        }

        FileS file = fileMapper.findOwnFile(findOwnFileBo);

        if (file == null){
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",file,"0x200");
    }

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param deleteFileOrFolderBo
     * @return
     */
    @Override
    public ResponseVo deleteFileOrFolder(DeleteFileOrFolderBo deleteFileOrFolderBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long judge = fileMapper.deleteFileOrFolder(deleteFileOrFolderBo);

        if (judge == 0L || judge == null) {
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",null,"0x200");
    }

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param selectUpdateByToFileBo
     * @return
     */
    @Override
    public ResponseVo selectUpdateByToFile(SelectUpdateByToFileBo selectUpdateByToFileBo) {

        String userIdOfStr= (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        SelectUpdateByToFileVo selectUpdateByToFileVo = fileMapper.selectUpdateByToFile(selectUpdateByToFileBo);

        if (selectUpdateByToFileVo == null) {
            return new ResponseVo("查询失败",null,"0x500");
        }

        return new ResponseVo("查询成功",selectUpdateByToFileVo,"0x200");
    }

    /**
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param updateFileOrFolderBo
     * @return
     */
    @Override
    public ResponseVo updateFileOrFolder(UpdateFileOrFolderBo updateFileOrFolderBo) {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败",null,"0x501");
        }

        String name = updateFileOrFolderBo.getServerFilename();
        String updateAfterName = name.substring(0,name.lastIndexOf("/") + 1) + updateFileOrFolderBo.getUpdateName();

        updateFileOrFolderBo.setServerFilename(updateAfterName);

        Long judge = fileMapper.updateFileOrFolder(updateFileOrFolderBo);

        if (judge == 0L || judge == null) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",null,"0x200");
    }

    /**
     * @author hln 2023-11-29
     *      下载文件功能
     * @param downloadFileBo
     * @return
     */
    @Override
    public ResponseVo downloadFile(DownloadFileBo downloadFileBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败",null,"0x501");
        }

        HttpServletResponse response = null;

        //获取file的path
        String serverFilename = downloadFileBo.getServerFilename();
        String filePath = fileMapper.selectToGetPathFile(serverFilename);

        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(String.valueOf(file));
            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer,0,bytesRead);
            }

            String fileName = file.getName();
            String contentType = "";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
