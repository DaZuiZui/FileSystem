package com.example.filesystem.service.impl;

import com.example.filesystem.mapper.UserMapper;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.FindAllNewVo;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.pojo.vo.UserFindAllVo;
import com.example.filesystem.pojo.vo.UserPagingToGetDataVo;
import com.example.filesystem.service.SystemService;
import com.example.filesystem.service.UserService;
import com.example.filesystem.util.JwtUtil;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SystemService systemService;
    /**
     * @author zhuxinyu 2023-11-28
     *      用户登录验证
     * @param userAddBo
     * @return
     */
    @Override
    public ResponseVo userAdd(UserAddBo userAddBo) {
        User userInDB = userMapper.userAdd(userAddBo);

        //比较用户密码和数据库中密码是否一致
        if (userInDB == null || !userInDB.getPassword().equals(userAddBo.getPassword())){
            return new ResponseVo("账号或密码错误",null,"0x201");
        }

        String token = JwtUtil.createJWT(userInDB);
        Integer role = userInDB.getRole();
        String name = userInDB.getName();
        String username = userInDB.getUsername();
        String org = userInDB.getOrg();
        Long grade = userInDB.getGrade();

        //登录时权限变为用户角色
        userInDB.setRole(0);

        HashMap<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("role",role);
        map.put("name",name);
        map.put("username",username);
        map.put("org",org);
        map.put("grade",grade);

        return new ResponseVo("登入成功",map,"0x200");
    }

    /**
     * @author zhuxinyu 2023-11-28
     *      用户删除
     * @param id
     * @return
     */
    @Override
    public ResponseVo userDelete(Long id, String token){

        systemService.isAdmin(token,1);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long aLong = userMapper.userDelete(id);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");

    }

    /**
     * @author zhuxinyu 2023-11-28
     *     用户查询
     * @param id
     * @return
     */
    @Override
    public ResponseVo userSelect(Long id , String token) {
        systemService.isAdmin(token,1);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        User user = userMapper.userSelect(id);

        if(user == null){
            return new ResponseVo("查询条件不存在",null,"0x500");
        }

        return new ResponseVo("查找成功",user,"0x200");

    }

    /**
     * @author zhuxinyu 2023-11-28
     *     用户更新
     * @param user
     * @return
     */
    @Override
    public ResponseVo userUpdate(User user) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        user.setUpdateBy(userId);
        user.setUpdateTime(new Date());
        Long aLong = userMapper.userUpdate(user);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",user.getId(),"0x200");
    }

    /**
     * @author zhuxinyu 2023-11-28
     *     用户注册
     * @param userRegBo
     * @return
     */
    @Override
    public ResponseVo userReg(UserRegBo userRegBo) {
        User username = userMapper.findByUsername(userRegBo.getUsername());

        if(username != null){
            return new ResponseVo("该username已经存在",null,"0x202");
        }

        Long aLong = userMapper.userReg(userRegBo);

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    /**
     * @author zhuxinyu 2023-12-01
     *      返回所有用户的基础信息
     * @return
     */
    @Override
    public ResponseVo userFindAll() {

        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }
        List<UserFindAllVo> list = userMapper.userFindAll();

        return new ResponseVo("查询成功",list,"0x200");
    }

    /**
     * @author zhuxinyu 2023-12-04
     *查询所有的分页查询，模糊查询
     * @param userFindAllBo
     * @return
     */
    @Override
    public ResponseVo findAllUser(UserFindAllBo userFindAllBo,String token) {
        //登录权限判定
        systemService.isAdmin(token,1);
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        int start = (userFindAllBo.getStart()-1)*userFindAllBo.getSize();
        userFindAllBo.setStart(start);
        List<UserFindAllVo> list;

        list = userMapper.findAllUser(userFindAllBo);

        int count = userMapper.selectToGetCount(userFindAllBo);
        FindAllNewVo findAllVoNew = new FindAllNewVo();
        findAllVoNew.setList(list);
        findAllVoNew.setCount(count);

        return new ResponseVo("查询成功",findAllVoNew,"0x200");
    }

    /**
     * @author zhuxinyu 2023-12-02
     *      分页查询
     * @param userPagingToGetDataBo
     * @return
     */
    @Override
    public ResponseVo userPagingToGetData(UserPagingToGetDataBo userPagingToGetDataBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);
        List<User> userList = userMapper.userPagingToGetUserData(userPagingToGetDataBo);
        UserPagingToGetDataVo userPagingToGetDataVo = new UserPagingToGetDataVo();
        userPagingToGetDataVo.setCount(userList.size());
        userPagingToGetDataVo.setList(userList);

        return null;
    }
}
