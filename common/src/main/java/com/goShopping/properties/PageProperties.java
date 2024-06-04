package com.goShopping.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static org.apache.naming.SelectorContext.prefix;

@ConfigurationProperties(prefix="com.shopping")
@Component
@Data
public class PageProperties {
    private Integer pageSize;
}
