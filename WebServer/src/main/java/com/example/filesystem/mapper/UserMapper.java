package com.example.filesystem.mapper;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
     * @param user
     * @return
     */
    Long userReg(User user);
}
