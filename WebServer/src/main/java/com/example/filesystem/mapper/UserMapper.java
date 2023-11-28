package com.example.filesystem.mapper;

import com.example.filesystem.pojo.User;
import com.example.filesystem.pojo.bo.UserAddBo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User userAdd(UserAddBo userAddBo);

    Long userDelete(Long id);

    User userSelect(Long id);

    Long userUpdate(User user);

    User findByUsername(String username);

    Long userReg(User user);
}
