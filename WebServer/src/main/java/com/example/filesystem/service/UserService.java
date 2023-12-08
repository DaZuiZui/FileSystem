package com.example.filesystem.service;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.*;
import com.example.filesystem.pojo.vo.ResponseVo;

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
     * @param id
     * @return
     */
    ResponseVo userDelete(Long id,String token) throws IOException;

    /**
     * @author zhuxinyu 2023-11-28
     *     用户查询
     * @param id
     * @return
     */
    ResponseVo userSelect(Long id,String token) throws IOException;

    /**
     * @author zhuxinyu 2023-11-28
     *     用户更新
     * @param user
     * @return
     */
    ResponseVo userUpdate(User user , String token) throws IOException;

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
    ResponseVo findAllUser(UserFindAllBo userFindAllBo,String token)throws IOException;

    /**
     * @author zhuxinyu 2023-12-02
     *      分页查询
     * @param userPagingToGetDataBo
     * @return
     */
    ResponseVo userPagingToGetData(UserPagingToGetDataBo userPagingToGetDataBo);
}
