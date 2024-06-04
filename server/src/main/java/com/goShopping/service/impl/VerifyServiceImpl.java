package com.goShopping.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goShopping.entity.Code;
import com.goShopping.entity.StorageCode;
import com.goShopping.properties.CodeProperties;
import com.goShopping.service.VerifyService;
import com.goShopping.utils.CodeUtils;
import com.goShopping.utils.SessionUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service

public class VerifyServiceImpl implements VerifyService {
    @Autowired
    CodeUtils codeUtils;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    CodeProperties codeProperties;
    @Override
    public Code getCode() {
        return codeUtils.createCode();
    }

    @Override
    public void storageCodeInSession(HttpServletRequest httpServletRequest,Code code) {
       SessionUtils.storage(httpServletRequest,code);
    }

    @Override
    public void storageCodeInRedis(Code code,String temporaryId) {
        StorageCode storageCode = StorageCode.builder().expireTime(code.getExpireTime()).code(code.getCode()).build();
        String jsonCode =  JSONObject.toJSONString(storageCode);
        stringRedisTemplate.opsForValue().set(temporaryId, jsonCode,codeProperties.getExpireTime(), TimeUnit.SECONDS);
    }

    @Override
    public StorageCode getCodeFromRedis(String temporaryId) {
        return JSON.parseObject(stringRedisTemplate.opsForValue().get(temporaryId), StorageCode.class);
    }
}
