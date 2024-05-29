package com.goShopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageCode {
    private String code;
    private LocalDateTime expireTime;
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
}
