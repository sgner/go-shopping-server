package com.goShopping.mapper;

import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User findUserByUsername(String username);

    void insert(UserRegisterDTO userRegisterDTO);
}
