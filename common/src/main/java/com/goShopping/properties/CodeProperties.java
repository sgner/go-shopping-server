package com.goShopping.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.shopping.code")
@Data
public class CodeProperties {
    private long expireTime;
    private int width;
    private int height;
    private int length;
}
