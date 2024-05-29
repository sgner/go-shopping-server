package com.goShopping.service;

import com.goShopping.entity.Code;
import com.goShopping.entity.StorageCode;
import jakarta.servlet.http.HttpServletRequest;

public interface VerifyService {
    public Code getCode();
    public void storageCodeInSession(HttpServletRequest httpServletRequest,Code code);
    public void storageCodeInRedis(Code code);
    public StorageCode getCodeFromRedis();
}
