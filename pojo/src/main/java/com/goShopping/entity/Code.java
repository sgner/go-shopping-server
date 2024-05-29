package com.goShopping.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
public class Code {
    private String code;
    private LocalDateTime expireTime;
    private Image image;
    public Code(String code , long expire, Image image){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expire);
        this.image = image;
    }
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
    public void setExpireTime(long expire){
        this.expireTime = LocalDateTime.now().plusSeconds(expire);
    }
}