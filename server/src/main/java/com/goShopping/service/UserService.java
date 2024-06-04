package com.goShopping.service;

import com.goShopping.dto.UserLoginDTO;
import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.entity.User;
import com.goShopping.result.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    Result login(UserLoginDTO userLoginDTO) throws Exception;

    Result register(UserRegisterDTO userRegisterDTO) throws Exception;

    Result recover(Claims claims) throws Exception;

    Result autoLogin(Claims claims);

    Result logout(String token,Claims claims);

    Result search(String message, Integer mode,Integer pageNum);
}
