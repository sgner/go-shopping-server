package com.goShopping.service.impl;

import com.goShopping.dto.UserLoginDTO;
import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.entity.StorageCode;
import com.goShopping.entity.User;
import com.goShopping.mapper.UserMapper;
import com.goShopping.properties.AesEncryptionProperties;
import com.goShopping.properties.JWTProperties;
import com.goShopping.result.Result;
import com.goShopping.service.UserService;
import com.goShopping.service.VerifyService;
import com.goShopping.utils.AesEncryptionUtils;
import com.goShopping.utils.CodeUtils;
import com.goShopping.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    CodeUtils codeUtils;
    @Autowired
    AesEncryptionProperties aesEncryptionProperties;
    @Autowired
    JWTProperties jwtProperties;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    VerifyService verifyService;
    @Override
    public Result login(UserLoginDTO userLoginDTO) throws Exception {
        StorageCode code = verifyService.getCodeFromRedis();
        if(!codeUtils.checkCode(userLoginDTO.getCode(),code)){
            return Result.error("验证码错误");
        }
        User user = userMapper.findUserByUsername(userLoginDTO.getUsername());
        if(user == null){
            return Result.error("用户名不存在");
        }
        if(!AesEncryptionUtils.decrypt(user.getPassword(),aesEncryptionProperties.getKey()).equals(userLoginDTO.getPassword())){
                       return Result.error("密码错误");
        }
        Map<String,Object> claims = new HashMap<>();
         claims.put("id",user.getId());
         claims.put("username",user.getUsername());
         String token = JWTUtils.createJWT(jwtProperties.getTtl(),jwtProperties.getSecretKey(),claims);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
         operations.set(token,token,jwtProperties.getTtl(), TimeUnit.MICROSECONDS);
        return Result.success();
    }

    @Override
    public Result register(UserRegisterDTO userRegisterDTO) throws Exception {
        User user = userMapper.findUserByUsername(userRegisterDTO.getUsername());
        if(user != null){
            return Result.error("用户名已存在");
        }
        userRegisterDTO.setPassword(AesEncryptionUtils.encrypt(userRegisterDTO.getPassword(),aesEncryptionProperties.getKey()));
        userMapper.insert(userRegisterDTO);
        return Result.success();
    }
}
