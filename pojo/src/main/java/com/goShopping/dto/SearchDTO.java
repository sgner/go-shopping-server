package com.goShopping.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchDTO {
   private String message;
   private Integer mode;
   private Integer basis;
   private Integer sort;
   private Integer pageNum;
}
