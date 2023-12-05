package com.example.filesystem.service.impl;


import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.mapper.UserMapper;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.SystemService;
import com.example.filesystem.util.JwtUtil;
import com.example.filesystem.util.ThreadLocalUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * 系统接口实现类
 */
@Service
public class SystemServiceImpl implements SystemService {


    @Autowired
    private UserMapper userMapper;

    /**
     * @author zhuxinyu 2023-11-28
     *      不同权限认证
     * @param token
     * @param leave
     * @return
     */
    @Override
    public ResponseVo isAdmin(String token, Integer leave) {
        //身份鉴权
        ResponseVo auth = this.auth(token);
        if (auth.getData() == null) {
            return null;
        }

        String strUserId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(strUserId);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        User userAdmin = userMapper.queryByUserId(userId);

        if (userAdmin == null || userAdmin.getRole() < leave){
            ThreadLocalUtil.mapThreadLocal.get().put("error","权限不足");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("权限不足",null,"0x404");
        }

        return null;
    }

    /**
     * 鉴权
     * @param token
     * @return
     */
    @Override
    public ResponseVo auth(String token) {
        try {
            Map<String, Object> map = JwtUtil.analysis(token);
//            String id = (String) analysis.get("id");
//            Long userId = Long.valueOf(id);
//            User user = userMapper.findById(userId);
            ThreadLocalUtil.mapThreadLocalOfJWT.get().put("userinfo",map);
            System.out.println(ThreadLocalUtil.mapThreadLocalOfJWT);
            return new ResponseVo(null,map,"0x200");
        } catch (Exception e) {
            //e.printStackTrace();
            ThreadLocalUtil.mapThreadLocal.get().put("error","身份验证过期");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("身份登入验证过期",null,"0x203");
        }
    }


    /**
     * @author zhuxinyu 2023-11-28
     * 非幂等性处理
     * @return
     */
    @Override
    public String getNonPower() {
        return "";
    }


}