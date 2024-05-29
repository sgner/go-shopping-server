package com.goShopping.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.goShopping.entity.Code;
import com.goShopping.entity.StorageCode;
import com.goShopping.properties.CodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils{
      @Autowired
      CodeProperties codeProperties;
      @Autowired
      Code code;
       public Code createCode (){
           ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(codeProperties.getWidth(),codeProperties.getHeight(),codeProperties.getLength(),2);
           String codeCaptcha = captcha.getCode();
           code.setExpireTime(codeProperties.getExpireTime());
           code.setCode(codeCaptcha);
           code.setImage(captcha.getImage());
           return code;
       }
       public boolean checkCode(String userCode , StorageCode code){
               if(code == null || code.isExpired()){
                   return false;
               }
           return code.getCode().equalsIgnoreCase(userCode.trim());
       }
}
