package com.example.filesystem.mapper;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import com.example.filesystem.pojo.bo.UserFindAllBo;
import com.example.filesystem.pojo.bo.UserPagingToGetDataBo;
import com.example.filesystem.pojo.bo.UserRegBo;
import com.example.filesystem.pojo.vo.UserFindAllVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * @author zhuxinyu 2023-11-28
     *      在用户表中查找目标用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id} LIMIT 1")
    User queryByUserId(@Param("id")Long id);

    /**
     * @author zhuxinyu 2023-11-28
     *      用户登入
     * @param userAddBo
     * @return
     */
    User userAdd(UserAddBo userAddBo);

    /**
     * @author zhuxinyu 2023-11-28
     *      通过id删除用户
     * @param id
     * @return
     */
    Long userDelete(Long id);

    /**
     * @author zhuxinyu 2023-11-28
     *      通过id查询用户
     * @param id
     * @return
     */
    User userSelect(Long id);

    /**
     * @author zhuxinyu 2023-11-28
     *      通过id修改用户
     * @param user
     * @return
     */
    Long userUpdate(User user);

    /**
     * @author zhuxinyu 2023-11-28
     *     根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * @author zhuxinyu 2023-11-28
     *      用户注册
     * @param userRegBo
     * @return
     */
    Long userReg(UserRegBo userRegBo);

    /**
     * @author zhuxinyu 2023-12-01
     *      返回所有用户的基础信息
     * @return
     */
    List<UserFindAllVo> userFindAll();

    List<UserFindAllVo> findAllUser(UserFindAllBo userFindAllBo);
    /**
     * @auther zhuxinyu 2023-12-02
     *      分页查询
     * @param userPagingToGetDataBo
     * @return
     */
    List<User> userPagingToGetUserData(UserPagingToGetDataBo userPagingToGetDataBo);

    /**
     * @author zhuxinyu 2023-12-03
     *      返回用户表中所有数据的个数
     * @return
     */
    int selectToGetCount(UserFindAllBo userFindAllBo);
}
