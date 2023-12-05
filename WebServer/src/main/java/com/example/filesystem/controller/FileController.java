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
    public String findOwnFile(HttpServletRequest httpServletRequest){

        String token = httpServletRequest.getHeader("Cookie");

        return fileService.findOwnFile(token.substring(6));
    }

//    /**
//     * @author hln 2023-11-28
//     *      显示自己的文件
//     * @param findOwnFileBo
//     * @return
//     */
//    @PostMapping("/findOwnFile")
//    @ApiOperation("显示自己的文件")
//    public String findOwnFile(@RequestBody FindOwnFileBo findOwnFileBo){
//        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
//        ThreadLocalUtil.mapThreadLocal.remove();
//
//        if(map.get("error") != null){
//            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
//        }
//
//        return JSONArray.toJSONString(fileService.findOwnFile(findOwnFileBo));
//    }

    /**
     * @author hln 2023-11-28
     *      删除文件或文件夹
     * @param deleteFileOrFolderBo
     * @return
     */
    @PostMapping("/deleteFileOrFolder")
    @ApiOperation("删除文件或文件夹")
    public String deleteFileOrFolder(@RequestBody DeleteFileOrFolderBo deleteFileOrFolderBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(fileService.deleteFileOrFolder(deleteFileOrFolderBo));
    }

    /**
     * @author hln 2023-11-28
     *      查看修改文件的人
     * @param selectUpdateByToFileBo
     * @return
     */
    @PostMapping("/selectUpdateByToFile")
    @ApiOperation("查看修改文件的人")
    public String selectUpdateByToFile(@RequestBody SelectUpdateByToFileBo selectUpdateByToFileBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(fileService.selectUpdateByToFile(selectUpdateByToFileBo));
    }

    /**
     * @author hln 2023-11-28
     *      重命名文件或文件夹
     * @param updateFileOrFolderBo
     * @return
     */
    @PostMapping("/updateFileOrFolder")
    @ApiOperation("重命名文件或文件夹")
    public String updateFileOrFolder(@RequestBody UpdateFileOrFolderBo updateFileOrFolderBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(fileService.updateFileOrFolder(updateFileOrFolderBo));
    }

//    /**
//     * @author hln 2023-11-29
//     *      下载文件功能
//     * @param downloadFileBo
//     * @return
//     */
//    @PostMapping("/downloadFile")
//    @ApiOperation("下载文件功能")
//    public String downloadFile(@RequestBody DownloadFileBo downloadFileBo, HttpServletResponse response){
//        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
//        ThreadLocalUtil.mapThreadLocal.remove();
//
//        if (map.get("error") != null) {
//            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
//        }
//
//        return JSONArray.toJSONString(fileService.downloadFile(downloadFileBo,response));
//    }

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
