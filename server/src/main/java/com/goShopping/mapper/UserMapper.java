package com.goShopping.mapper;

import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.entity.User;
import com.goShopping.vo.RecoverVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import static net.sf.jsqlparser.parser.feature.Feature.select;

@Transactional
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User findUserByUsername(String username);

    void insert(User newUser);
    @Select("select * from user where id=#{id}")
    User searchUserById(int id);
    @Update("update user set isAuto=false where id=#{id}")
    void logout(Integer id);
}
