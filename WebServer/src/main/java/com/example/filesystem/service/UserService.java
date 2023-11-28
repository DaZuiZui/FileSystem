package com.example.filesystem.service;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import com.example.filesystem.pojo.bo.UserDeleteBo;
import com.example.filesystem.pojo.bo.UserSelectBo;
import com.example.filesystem.pojo.bo.UserUpdateBo;
import com.example.filesystem.pojo.vo.ResponseVo;

import javax.xml.ws.Response;

public interface UserService {

    ResponseVo userAdd(UserAddBo userAddBo);

    ResponseVo userDelete(UserDeleteBo userDeleteBo);

    ResponseVo userSelect(UserSelectBo userSelectBo);

    ResponseVo userUpdate(UserUpdateBo userUpdateBo);

    ResponseVo userReg(User user);
}
