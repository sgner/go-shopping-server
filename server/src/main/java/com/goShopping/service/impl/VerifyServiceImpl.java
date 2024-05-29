package com.goShopping.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goShopping.entity.Code;
import com.goShopping.entity.StorageCode;
import com.goShopping.service.VerifyService;
import com.goShopping.utils.CodeUtils;
import com.goShopping.utils.SessionUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service

public class VerifyServiceImpl implements VerifyService {
    @Autowired
    CodeUtils codeUtils;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public Code getCode() {
        return codeUtils.createCode();
    }

    @Override
    public void storageCodeInSession(HttpServletRequest httpServletRequest,Code code) {
       SessionUtils.storage(httpServletRequest,code);
    }

    @Override
    public void storageCodeInRedis(Code code) {
        StorageCode storageCode = StorageCode.builder().expireTime(code.getExpireTime()).code(code.getCode()).build();
        String jsonCode =  JSONObject.toJSONString(storageCode);
        stringRedisTemplate.opsForValue().set("code", jsonCode);
    }

    @Override
    public StorageCode getCodeFromRedis() {
        return JSON.parseObject(stringRedisTemplate.opsForValue().get("code"), StorageCode.class);
    }
}
