package com.example.filesystem.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.mapper.FileMapper;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static com.example.filesystem.util.JwtUtil.analysis;

@Service
public class FileServiceImpl implements FileService {

    @Value("${filePath}")
    private String path;
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
    public ResponseVo downloadFile(DownloadFileBo downloadFileBo, HttpServletResponse response) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return new ResponseVo("token解析失败", null, "0x501");
        }

        // 获取file的path
        String serverFilename = downloadFileBo.getServerFilename();
        String filePath = fileMapper.selectToGetPathFile(serverFilename);

        File file = new File(filePath);
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {

            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setContentType("application/octet-stream");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
            // 处理异常，返回适当的错误信息
            return new ResponseVo("文件下载失败", null, "0x502");
        }

        return new ResponseVo("文件下载成功",null,"0x200");
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
     * @author Oh...Yeah!!! 2023-11-13
     *    文件上传
     * @param token
     * @param file
     * @return String.class
     */
    @Override
    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException{
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的文件才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生文件替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;

        //获取username
        Map<String, Object> analysis = analysis(token);
        String id = (String) analysis.get("id");

        File saveFilePath = new File(path+""+id+"/");
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFilePath.exists()){
            saveFilePath.mkdirs();
        }

        String imgUrl = id+"/"+fileName;

        file.transferTo(new File(path+imgUrl));

        long userId = Long.parseLong(id);

        com.example.filesystem.pojo.File newFile = new com.example.filesystem.pojo.File(
                path+""+id+"/"+ fileName,"/" + fileName,
                file.getSize(),0,0,
                suffixName,userId,new Date(),
                userId,new Date(),0,0
        );

        fileMapper.addFile(newFile);


        return JSONArray.toJSONString(new ResponseVo<>("success",projecturl+"/system/getfile?fileUrl="+id+"/"+fileName,"0x200"));
    }


}
