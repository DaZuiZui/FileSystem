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


}
