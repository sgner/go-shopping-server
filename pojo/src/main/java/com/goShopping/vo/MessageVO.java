package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageVO {
     private String title;
     private int messageId;
}
