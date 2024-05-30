package com.goShopping.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LongTermEventBookBodyItemVO {
    private String image;
    private String describe;
    private Double originalPrice;
    private Double price;
    private int discount;
}
