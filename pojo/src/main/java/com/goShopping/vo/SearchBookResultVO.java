package com.goShopping.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchBookResultVO {
    private String image;
    private String name;
    private String author;
    private LocalDate publishedDate;
    private String publisher;
    private Double price;
    private Double discount;
    private Double originalPrice;
    private String detail;
}
