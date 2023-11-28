package com.example.filesystem.mapper;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id} LIMIT 1")
    User queryByUserId(@Param("id")Long id);

    User userAdd(UserAddBo userAddBo);

    Long userDelete(Long id);

    User userSelect(Long id);

    Long userUpdate(User user);

    User findByUsername(String username);

    Long userReg(User user);
}
