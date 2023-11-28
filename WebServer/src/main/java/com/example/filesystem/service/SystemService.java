package com.example.filesystem.service;

import com.example.filesystem.pojo.vo.ResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 系统接口
 */
@Service
public interface SystemService {

    /**
     * is amdin
     * @param token
     * @param leave
     * @return
     */
    public ResponseVo isAdmin(String token,Integer leave);

    /**
     * 鉴权
     * @param token
     * @return
     */
    public ResponseVo auth(String token);


    public String getNonPower();


    @ApiOperation("文件下载")
    @GetMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException;


    public String imgUpDown(@RequestParam("file") MultipartFile file, @RequestParam("token")String token) throws IOException;
}
