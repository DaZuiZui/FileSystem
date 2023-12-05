package com.example.filesystem.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.mapper.FileMapper;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.pojo.vo.SelectUpdateByToFileVo;
import com.example.filesystem.pojo.vo.UpdateFileOrFolderVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.service.SystemService;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.example.filesystem.util.JwtUtil.analysis;

@Service
public class FileServiceImpl implements FileService {

//    @Value("${filePath}")
    private String path;
    @Value("${projecturl}")
    private String projecturl;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private SystemService systemService;

    /**
     * @param token
     * @return
     * @author hln 2023-12-05
     * 显示自己的文件
     */
    @Override
//    public String findOwnFile(@RequestParam("token") String token) {
    public String findOwnFile(String token) {

        //确认登录状态
        systemService.auth(token);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return JSONArray.toJSONString(new ResponseVo("token解析失败",null,"0x501"));
        }

        List<com.example.filesystem.pojo.File> file = fileMapper.findOwnFile(userId);

        return JSONArray.toJSONString(new ResponseVo("查询成功",file,"0x200"));
    }


    /**
     * @param serverFilename
     * @param token
     * @return
     * @author hln 2023-12-05
     * 删除文件或文件夹
     */
    @Override
    public String deleteFileOrFolder(String serverFilename, String token) {
//    public String deleteFileOrFolder(@RequestParam("serverFilename") String serverFilename, @RequestParam("token") String token) {

        systemService.auth(token);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return JSONArray.toJSONString(new ResponseVo("token解析失败",null,"0x501"));
        }

        Long judge = fileMapper.deleteFileOrFolder(serverFilename);

        if (judge == 0L || judge == null) {
            return JSONArray.toJSONString(new ResponseVo("删除失败",null,"0x500"));
        }

        return JSONArray.toJSONString(new ResponseVo("删除成功",null,"0x200"));
    }

    /**
     * @author hln 2023-12-05
     *      查看修改文件的人
     * @param serverFilename
     * @param token
     * @return
     */
    @Override
    public String selectUpdateByToFile(String serverFilename, String token) {

        systemService.auth(token);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return JSONArray.toJSONString(new ResponseVo("token解析失败",null,"0x501"));
        }

        List<SelectUpdateByToFileVo> list = fileMapper.selectUpdateByToFile(serverFilename);

        return JSONArray.toJSONString(new ResponseVo("删除成功",list,"0x200"));
    }

    /**
     * @author hln 2023-12-05
     *      重命名文件或文件夹
     * @param serverFilename
     * @param updateName
     * @param token
     * @return
     */
    @Override
    public String updateFileOrFolder(String serverFilename, String updateName, String token) {

        systemService.auth(token);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if (userId == null || userId == 0L) {
            return JSONArray.toJSONString(new ResponseVo("token解析失败",null,"0x501"));
        }

        fileMapper.updateFileOrFolder(serverFilename,updateName);

        return JSONArray.toJSONString(new ResponseVo<>("修改成功",null,"0x200"));
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
