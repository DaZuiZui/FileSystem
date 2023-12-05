package com.example.filesystem.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.mapper.FileMapper;
import com.example.filesystem.pojo.FileDownLoad;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import com.example.filesystem.pojo.vo.UpdateFileOrFolderVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static com.example.filesystem.util.JwtUtil.analysis;

@Service
public class FileServiceImpl implements FileService {


    @Value("${projecturl}")
    private String projecturl;
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

        com.example.filesystem.pojo.File file = fileMapper.findOwnFile(findOwnFileBo);

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

        UpdateFileOrFolderVo updateFileOrFolderVo = new UpdateFileOrFolderVo();

        String name = updateFileOrFolderBo.getServerFilename();
        String updateAfterName = name.substring(0,name.lastIndexOf("/") + 1) + updateFileOrFolderBo.getUpdateName();

        updateFileOrFolderVo.setServerFilename(updateFileOrFolderBo.getServerFilename());
        updateFileOrFolderVo.setLastName(updateAfterName);

        Long judge = fileMapper.updateFileOrFolder(updateFileOrFolderVo);

        if (judge == 0L || judge == null) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",null,"0x200");
    }


    /**
     * @author zzy 2023-11-30
     *      新建文件夹
     * @param insertFolderBo
     * @return
     */
    @Override
    public ResponseVo insertFolder(InsertFolderBo insertFolderBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败", null, "0x501");
        }

        Long file = fileMapper.insertFolder(insertFolderBo);
        if (file == 0L || file == null) {
            return new ResponseVo("添加失败",null,"0x500");
        }

        return new ResponseVo("添加成功",null,"0x200");

    }
    /**
     * @author zzy 2023-11-30
     *      移动文件或文件夹
     * @param moveFileOrFolderBo
     * @return
     */

    @Override
    public ResponseVo moveFileOrFolder(MoveFileOrFolderBo moveFileOrFolderBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败", null, "0x501");
        }
        Long judge = fileMapper.moveFileOrFolder(moveFileOrFolderBo);
        if (judge == 0L || judge == null) {
            return new ResponseVo("移动失败",null,"0x500");
        }

        return new ResponseVo("移动成功",null,"0x200");

    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    文件下载
     * @param
     * @param
     * @return String.class
     */
    @Override
    public ResponseVo download(String reteFilePath, String loFilePath) {

        String sourceFilePath = "reteFilePath"; //源文件路径
        String targetFolderPath = "loFilePath"; //目标文件路径

        try {

            // 创建目标文件夹（如果不存在）
            File targetFolder = new File(targetFolderPath);
            if (!targetFolder.exists()) {
                targetFolder.mkdir();
            }

            // 打开源文件和目标文件通道
            FileInputStream sourceFileInputStream = new FileInputStream(sourceFilePath);
            FileOutputStream targetFileOutputStream = new FileOutputStream(targetFolderPath + "/" + new File(sourceFilePath).getName());
            FileChannel sourceFileChannel = sourceFileInputStream.getChannel();
            FileChannel targetFileChannel = targetFileOutputStream.getChannel();

            // 分配直接内存缓冲区
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024);

            // 从源文件通道读取数据，并写入目标文件通道
            while (sourceFileChannel.read(buffer) != -1) {
                buffer.flip();
                targetFileChannel.write(buffer);
                buffer.clear();
            }

            // 关闭通道和流
            sourceFileChannel.close();
            targetFileChannel.close();
            sourceFileInputStream.close();
            targetFileOutputStream.close();

            FileDownLoad fd = new FileDownLoad();



          //  fileMapper.addFileDownLoad();


            return new ResponseVo<>("success",null,"0x200");

        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseVo<>("fail",null,"0x507");



        }



    }


    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    文件上传
     * @param token
     * @param file
     * @return String.class
     */
    @Override
    public String fileUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException{
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的文件才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生文件替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;

        //获取username
        Map<String, Object> analysis = analysis(token);
        String id = (String) analysis.get("id");

        File saveFilePath = new File("src//main//resources//file//user//"+id+"/");
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFilePath.exists()){
            saveFilePath.mkdirs();
        }

        String imgUrl = id+"/"+fileName;

        File file1 = new File("src//main//resources//file/user//" + imgUrl);


        file.transferTo(new File(file1.getCanonicalPath()));

        long userId = Long.parseLong(id);

        String severPath = projecturl+"/system/getfile?fileUrl="+id+"/"+fileName;

        com.example.filesystem.pojo.File newFile = new com.example.filesystem.pojo.File(
                severPath,"/" + fileName,
                file.getSize(),0,0,
                suffixName,userId,new Date(),
                userId,new Date(),0,0
        );

        fileMapper.addFile(newFile);


        return JSONArray.toJSONString(new ResponseVo<>("success",severPath,"0x200"));
    }





}
