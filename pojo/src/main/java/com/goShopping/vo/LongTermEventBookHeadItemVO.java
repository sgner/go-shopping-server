package com.goShopping.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LongTermEventBookHeadItemVO {
        private Integer id;
        private String image;
        private String describe;
        private Double price;
        private Double originalPrice;
        private String detail;
        private Double discount;
        private Double rate;
        private int comment;
}
