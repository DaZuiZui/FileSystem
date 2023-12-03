package com.example.filesystem.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.*;
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

    /**
     * @author zhuxinyu 2023-11-28
     *   用户登录
     * @param userAddBo
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登入")
    public String userAdd(@RequestBody UserAddBo userAddBo){
        if (userAddBo == null){
            com.alibaba.fastjson2.JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }

        return JSONArray.toJSONString(userService.userAdd(userAddBo));
    }

    /**
     * @author zhuxinyu 2023-11-28
     *     根据用户id删除
     * @param userDeleteBo
     * @return
     */
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

    /**
     * @author zhuxinyu 2023-11-28
     *      根据用户id查询
     * @param userSelectBo
     * @return
     */
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

    /**
     * @author zhuxinyu 2023-11-28
     *      根据用户id修改
     * @param userUpdateBo
     * @return
     */
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

    /**
     * @author zhuxinyu 2023-11-28
     *      用户注册
     * @param userRegBo
     * @return
     */
    @PostMapping("/userReg")
    @ApiOperation("注册用户")
    public String userReg(@RequestBody UserRegBo userRegBo){
        if (userRegBo == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }
        return JSONArray.toJSONString(userService.userReg(userRegBo));
    }

    /**
     * @author zhuxinyu 2023-12-01
     *      返回所有用户的基础信息
     * @param token
     * @return
     */
    @PostMapping("/userFindAll")
    @ApiOperation("返回所有用户的基础信息")
    public String userFindAll(@RequestParam String token){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }

        return JSONArray.toJSONString(userService.userFindAll());
    }

    /**
     * @author zhuxinyu 2023-12-02
     *      分页查询
     * @param userPagingToGetDataBo
     * @return
     */
    @PostMapping("/paingQuery")
    @ApiOperation("分页查询")
    public String userPaingToGetData(@RequestBody UserPagingToGetDataBo userPagingToGetDataBo){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        if (userPagingToGetDataBo == null) {
            return JSONArray.toJSONString(new ResponseVo<>("参数为null",null,"0x455"));
        }
        return JSONArray.toJSONString(userService.userPagingToGetData(userPagingToGetDataBo));
    }

}
