package com.example.filesystem.service;

import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


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
    ResponseVo userDelete(UserDeleteBo userDeleteBo,@RequestParam("token")String token) throws IOException;

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

    /**
     * @author zhuxinyu 2023-12-04
     * 查询所有的分页查询，模糊查询
     * @param userFindAllBo
     * @return
     */
    ResponseVo findAllUser(UserFindAllBo userFindAllBo);

    /**
     * @author zhuxinyu 2023-12-02
     *      分页查询
     * @param userPagingToGetDataBo
     * @return
     */
    ResponseVo userPagingToGetData(UserPagingToGetDataBo userPagingToGetDataBo);
}
