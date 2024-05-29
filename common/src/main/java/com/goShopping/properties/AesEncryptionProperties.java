package com.goShopping.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "com.shopping.password")
@Data
public class AesEncryptionProperties {
    private String key;
}
