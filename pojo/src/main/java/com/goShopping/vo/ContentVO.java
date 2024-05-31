package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentVO {
    private String image;
    private String text;
}
