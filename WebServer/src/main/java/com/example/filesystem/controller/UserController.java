package com.example.filesystem.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import com.example.filesystem.pojo.bo.UserDeleteBo;
import com.example.filesystem.pojo.bo.UserSelectBo;
import com.example.filesystem.pojo.bo.UserUpdateBo;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.UserService;
import com.example.filesystem.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Login")
    @ApiOperation("用户登入")
    public String userAdd(@RequestBody UserAddBo userAddBo){
        if (userAddBo == null){
            com.alibaba.fastjson2.JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }

        return JSONArray.toJSONString(userService.userAdd(userAddBo));
    }


    @PostMapping("/delete")
    @ApiOperation("删除用户通过id")
    public String userDelete(@RequestBody UserDeleteBo userDeleteBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userService.userDelete(userDeleteBo));
    }

    @PostMapping("/select")
    @ApiOperation("查询用户通过id")
    public String userSelect(@RequestBody UserSelectBo userSelectBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.userSelect(userSelectBo));
    }


    @PostMapping("/update")
    @ApiOperation("修改用户通过id")
    public String userUpdate(@RequestBody UserUpdateBo userUpdateBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userService.userUpdate(userUpdateBo));
    }


    @PostMapping("/userReg")
    @ApiOperation("注册用户")
    public String userReg(@RequestBody User user){
        if (user == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }
        return JSONArray.toJSONString(userService.userReg(user));
    }




}
