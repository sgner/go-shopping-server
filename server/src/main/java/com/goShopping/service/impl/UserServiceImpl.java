package com.goShopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goShopping.dto.UserLoginDTO;
import com.goShopping.dto.UserRegisterDTO;
import com.goShopping.entity.StorageCode;
import com.goShopping.entity.User;
import com.goShopping.mapper.SystemMapper;
import com.goShopping.mapper.UserMapper;
import com.goShopping.properties.AesEncryptionProperties;
import com.goShopping.properties.JWTProperties;
import com.goShopping.properties.PageProperties;
import com.goShopping.result.PageSearchResult;
import com.goShopping.result.Result;
import com.goShopping.service.UserService;
import com.goShopping.service.VerifyService;
import com.goShopping.utils.AesEncryptionUtils;
import com.goShopping.utils.CodeUtils;
import com.goShopping.utils.JWTUtils;
import com.goShopping.vo.RecoverVO;
import com.goShopping.vo.SearchBookResultVO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
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
    @Autowired
    SystemMapper systemMapper;
    @Autowired
    PageProperties pageProperties;
    @Override
    public Result login(UserLoginDTO userLoginDTO) throws Exception {
        StorageCode code = verifyService.getCodeFromRedis(userLoginDTO.getTemporaryId());
        log.info("用户输入验证码{}",userLoginDTO.getCode());
        log.info("redis中的验证码{}",code);
        if(!codeUtils.checkCode(userLoginDTO.getCode(),code)){
            return Result.error("验证码错误或过期，请重试");
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
        return Result.success(token);
    }

    @Override
    public Result register(UserRegisterDTO userRegisterDTO) throws Exception {
        User user = userMapper.findUserByUsername(userRegisterDTO.getUsername());
        if(user != null){
            return Result.error("用户名已存在");
        }
        userRegisterDTO.setPassword(AesEncryptionUtils.encrypt(userRegisterDTO.getPassword(),aesEncryptionProperties.getKey()));
        User newUser = User.builder().build();
        BeanUtils.copyProperties(userRegisterDTO,newUser);
        newUser.setStatus(1);
        userMapper.insert(newUser);
        return Result.success();
    }

    @Override
    public Result recover(Claims claims) throws Exception {
        User user = userMapper.searchUserById((Integer) ((Map<String,Object>) claims).get("id"));
      RecoverVO recoverVO  = RecoverVO.builder().build();
      BeanUtils.copyProperties(user,recoverVO);
      recoverVO.setPassword(AesEncryptionUtils.decrypt(user.getPassword(),aesEncryptionProperties.getKey()));
      return Result.success(recoverVO);
    }

    @Override
    public Result autoLogin(Claims claims) {
        User user = userMapper.searchUserById((Integer) ((Map<String,Object>) claims).get("id"));
        User user2 = userMapper.findUserByUsername((String) ((Map<String,Object>) claims).get("username"));
        if(user!=null && user2 != null){
            return Result.success();
        }
        return Result.error("自动登录失败，请重新登录");
    }

    @Override
    public Result logout(String token,Claims claims) {
             stringRedisTemplate.opsForValue().set(token,"");
             userMapper.logout((Integer) ((Map<String,Object>) claims).get("id"));
             return Result.success();
    }

    @Override
    public Result search(String message, Integer mode ,Integer pageNum) {
             PageHelper.startPage(pageNum,pageProperties.getPageSize());
             Page<SearchBookResultVO> result = null;
             if(mode == 1){
                 result =(Page<SearchBookResultVO>) systemMapper.searchBookByAuthor(message);
             }else if(mode == 2){
                 result  = (Page<SearchBookResultVO>) systemMapper.searchBookByName(message);
             }else{
                  result = (Page<SearchBookResultVO>) systemMapper.searchBookByPublisher(message);
             }
             return Result.success(PageSearchResult.builder().books(result.getResult()).total(result.getTotal()).build());
    }

    @Override
    public Result searchSort(String message, Integer mode, Integer basis, Integer sort, Integer pageNum) {
        PageHelper.startPage(pageNum,pageProperties.getPageSize());
        Page<SearchBookResultVO> result = null;
        if(mode == 1){
            result = (Page<SearchBookResultVO>)systemMapper.searchBookByAuthorSort(message,basis,sort);
        }else if(mode == 2){
            result  =
        }else{
            result =
        }
        return Result.success();
    }
}
