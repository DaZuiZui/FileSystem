package com.example.filesystem.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.FileService;
import com.example.filesystem.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@Api(value = "文件板块接口",tags = {"文件板块接口"})
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    private FileService fileService;


//    @ApiOperation("文件从服务器下载")
//    @RequestMapping(value = "downloadfile",method = {RequestMethod.POST})
//    public void upload(HttpServletRequest httpServletRequest,@RequestParam  String reteFilePath ,@RequestParam String loFilePath ) throws Exception {
//
//        //此处传入文件的绝对路径
//        FtpUtils.download(reteFilePath,loFilePath);
//
//    }
//
//    /**
//     * @author Oh...Yeah!!! 2023-11-13
//     *    文件上传到服务器
//     * @param
//     * @param file
//     * @return String.class
//     */
//    @ApiOperation("文件上传到服务器")
//    @RequestMapping(value = "file",method = {RequestMethod.POST})
//    public void upload(HttpServletRequest httpServletRequest,@RequestParam("file")  MultipartFile file) throws Exception {
//        byte[] bytes = file.getBytes();
//        FtpUtils.sshSftp(bytes,file.getOriginalFilename());
//
//    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    文件本地上传
     * @param file
     * @return String.class
     */
    @ApiOperation("文件上传")
    @RequestMapping(value = "imgUpDown",method = {RequestMethod.POST})
    public String fileUpDown(HttpServletRequest httpServletRequest,@RequestParam("file") MultipartFile file ) throws IOException {

        //获取请求头中的token
        String token  = httpServletRequest.getHeader("Cookie");

        return fileService.fileUpDown(file,token.substring(6));

    }

    /**
     * @author hln 2023-12-05
     *      显示自己的文件
     * @return
     */
    @RequestMapping(value = "/findOwnFile" , method = RequestMethod.POST)
    @ApiOperation("显示自己的文件")
    public String findOwnFile(HttpServletRequest httpServletRequest,@RequestParam("filePath") String filePath){

        String token = httpServletRequest.getHeader("Cookie");

        return fileService.findOwnFile(filePath,token.substring(6));
    }

    /**
     * @author hln 2023-12-05
     *      删除文件或文件夹
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/deleteFileOrFolder" , method = RequestMethod.POST)
    @ApiOperation("删除文件或文件夹")
    public String deleteFileOrFolder(HttpServletRequest httpServletRequest , @RequestParam("serverFilename") String serverFilename){

        String token = httpServletRequest.getHeader("Cookie");

        return fileService.deleteFileOrFolder(serverFilename,token.substring(6));
    }

    /**
     * @author hln 2023-12-05
     *      查看修改文件的人
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/selectUpdateByToFile" , method = RequestMethod.POST)
    @ApiOperation("查看修改文件的人")
    public String selectUpdateByToFile(HttpServletRequest httpServletRequest,@RequestParam("serverFilename") String serverFilename){

        String token = httpServletRequest.getHeader("Cookie");

        return fileService.selectUpdateByToFile(serverFilename,token.substring(6));
    }

    /**
     * @author hln 2023-12-05
     *      重命名文件或文件夹
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/updateFileOrFolder" , method = RequestMethod.POST)
    @ApiOperation("重命名文件或文件夹")
    public String updateFileOrFolder(HttpServletRequest httpServletRequest,@RequestParam("serverFilename") String serverFilename,@RequestParam("updateName") String updateName){

        String token = httpServletRequest.getHeader("Cookie");

        return fileService.updateFileOrFolder(serverFilename,updateName,token.substring(6));
    }


    /**
     * @author zzy 2023-11-30
     *      新建文件夹
     * @param insertFolderBo
     * @return
     */
    @PostMapping("/insertFolder")
    @ApiOperation("新建文件夹")
    public String insertFolder(@RequestBody InsertFolderBo insertFolderBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(fileService.insertFolder(insertFolderBo));

    }

    /**
     * @author zzy 2023-11-30
     *      移动文件或文件夹
     * @param moveFileOrFolderBo
     * @return
     */
    @PostMapping("/moveFileOrFolder")
    @ApiOperation("移动文件或文件夹")
    public String moveFileOrFolder(@RequestBody MoveFileOrFolderBo moveFileOrFolderBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(fileService.moveFileOrFolder(moveFileOrFolderBo));
    }

}
