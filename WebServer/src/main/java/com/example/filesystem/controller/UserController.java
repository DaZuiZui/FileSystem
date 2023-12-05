package com.example.filesystem.controller;

import com.alibaba.fastjson2.JSONArray;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.SystemService;
import com.example.filesystem.service.UserService;
import com.example.filesystem.util.ThreadLocalUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SystemService systemService;
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
     * @param id
     * @return
     * @author zhuxinyu 2023-11-28
     * 根据用户id删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除用户通过id")
    public String userDelete(HttpServletRequest httpServletRequest, @RequestParam("id") Long id) throws IOException {

        String token = httpServletRequest.getHeader("Cookie");
        return JSONArray.toJSONString(userService.userDelete(id,token.substring(6)));
    }

    /**
     * @param id
     * @return
     * @author zhuxinyu 2023-11-28
     * 根据用户id查询
     */
    @PostMapping("/select")
    @ApiOperation("查询用户通过id")
    public String userSelect(HttpServletRequest httpServletRequest, @RequestParam Long id) throws IOException{
        String token = httpServletRequest.getHeader("Cookie");

        return JSONArray.toJSONString(userService.userSelect(id,token.substring(6)));
    }

    /**
     * @author zhuxinyu 2023-11-28
     *      根据用户id修改
     * @param user
     * @return
     */
    @PostMapping("/update")
    @ApiOperation("修改用户通过id")
    public String userUpdate(@RequestBody User user){
        Map<String, String> map = ThreadLocalUtil.mapThreadLocal.get();
        ThreadLocalUtil.mapThreadLocal.remove();
        if ( map.get("error") != null) {
            return JSONArray.toJSONString(new ResponseVo<>(map.get("error"),null,map.get("code")));
        }
        return JSONArray.toJSONString(userService.userUpdate(user));
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
     * @param userFindAllBo
     * @return
     * @author zhuxinyu 2023-12-01
     * 查询所有的分页查询，模糊查询
     */
    @PostMapping("/userFindAll")
    @ApiOperation("返回所有用户的基础信息")
    public String findAllUser(HttpServletRequest httpServletRequest , @RequestBody UserFindAllBo userFindAllBo)throws IOException{

        String token = httpServletRequest.getHeader("Cookie");

        return JSONArray.toJSONString(userService.findAllUser(userFindAllBo,token.substring(6)));
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
