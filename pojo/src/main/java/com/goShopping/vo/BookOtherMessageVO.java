package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class BookOtherMessageVO {
     private String title;
     private ArrayList<ContentVO> content;
}
