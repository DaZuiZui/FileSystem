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

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@CrossOrigin
@Api(value = "文件板块接口",tags = {"文件板块接口"})
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * @author hln 2023-11-28
     *      显示自己的文件
     * @param findOwnFileBo
     * @return
     */
    @PostMapping("/findOwnFile")
    @ApiOperation("显示自己的文件")
    public String findOwnFile(@RequestBody FindOwnFileBo findOwnFileBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if(map.get("error") != null){
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(fileService.findOwnFile(findOwnFileBo));
    }

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

    /**
     * @author hln 2023-11-29
     *      下载文件功能
     * @param downloadFileBo
     * @return
     */
    @PostMapping("/downloadFile")
    @ApiOperation("下载文件功能")
    public String downloadFile(@RequestBody DownloadFileBo downloadFileBo, HttpServletResponse response){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();

        if (map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(fileService.downloadFile(downloadFileBo,response));
    }

}
