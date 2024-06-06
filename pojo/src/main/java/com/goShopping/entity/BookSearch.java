package com.goShopping.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookSearch {
    private String message;
    private String mode;
    private String basis;
    private String sort;
    private Integer pageNum;
}
