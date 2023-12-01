package com.example.filesystem.service;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;



public interface UserService {
    /**
     * @author zhuxinyu 2023-11-28
     *     用户登入
     * @param userAddBo
     * @return
     */
    ResponseVo userAdd(UserAddBo userAddBo);

    /**
     * @author zhuxinyu 2023-11-28
     *     用户删除
     * @param userDeleteBo
     * @return
     */
    ResponseVo userDelete(UserDeleteBo userDeleteBo);

    /**
     * @author zhuxinyu 2023-11-28
     *     用户查询
     * @param userSelectBo
     * @return
     */
    ResponseVo userSelect(UserSelectBo userSelectBo);

    /**
     * @author zhuxinyu 2023-11-28
     *     用户更新
     * @param userUpdateBo
     * @return
     */
    ResponseVo userUpdate(UserUpdateBo userUpdateBo);

    /**
     * @author zhuxinyu 2023-11-28
     *     用户注册
     * @param userRegBo
     * @return
     */
    ResponseVo userReg(UserRegBo userRegBo);

    /**
     * @author zhuxinyu 2023-12-01
     *      返回所有用户的基础信息
     * @return
     */
    ResponseVo userFindAll();
}
