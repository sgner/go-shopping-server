package com.goShopping.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.shopping.jwt")
@Data
public class JWTProperties {
       private String secretKey;
       private long ttl;
       private String tokenName;
}
