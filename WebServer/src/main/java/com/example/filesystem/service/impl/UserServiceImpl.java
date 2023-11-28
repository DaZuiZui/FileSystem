package com.example.filesystem.service.impl;

import com.example.filesystem.mapper.UserMapper;
import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import com.example.filesystem.pojo.bo.UserDeleteBo;
import com.example.filesystem.pojo.bo.UserSelectBo;
import com.example.filesystem.pojo.bo.UserUpdateBo;
import com.example.filesystem.pojo.vo.ResponseVo;
import com.example.filesystem.service.UserService;
import com.example.filesystem.util.JwtUtil;
import com.example.filesystem.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo userAdd(UserAddBo userAddBo) {
        User userInDB = userMapper.userAdd(userAddBo);

        //比较用户密码和数据库中密码是否一致
        if (userInDB == null || !userInDB.getPassword().equals(userAddBo.getPassword())){
            return new ResponseVo("账号或密码错误",null,"0x201");
        }

        String token = JwtUtil.createJWT(userInDB);
        Integer role = userInDB.getRole();

        //登录时权限变为用户角色
        userInDB.setRole(0);

        HashMap<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("role",role);

        return new ResponseVo("登入成功",map,"0x200");
    }

    @Override
    public ResponseVo userDelete(UserDeleteBo userDeleteBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        Long aLong = userMapper.userDelete(userDeleteBo.getId());

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("删除失败",null,"0x500");
        }

        return new ResponseVo("删除成功",aLong,"0x200");

    }

    @Override
    public ResponseVo userSelect(UserSelectBo userSelectBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        User user = userMapper.userSelect(userSelectBo.getId());

        if(user == null){
            return new ResponseVo("查询条件不存在",null,"0x500");
        }

        return new ResponseVo("查找成功",user,"0x200");

    }

    @Override
    public ResponseVo userUpdate(UserUpdateBo userUpdateBo) {
        String userIdOfStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(userIdOfStr);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

        userUpdateBo.getUser().setUpdateBy(userId);
        userUpdateBo.getUser().setUpdateTime(new Date());
        User user = userUpdateBo.getUser();
        Long aLong = userMapper.userUpdate(user);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",user.getId(),"0x200");
    }

    @Override
    public ResponseVo userReg(User user) {
        User username = userMapper.findByUsername(user.getUsername());

        if(username != null){
            return new ResponseVo("该username已经存在",null,"0x202");
        }

        user.setCreateTime(new Date());

        user.setStatus(0);
        user.setDelFlag(0);
        Long aLong = userMapper.userReg(user);

        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }
}
