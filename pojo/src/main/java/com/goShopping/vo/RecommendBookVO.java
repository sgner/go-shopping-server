package com.goShopping.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecommendBookVO {
    private String id;
    private String describe;
    private String image;
    private String discount;
    private Double originalPrice;
    private Double price;
}
