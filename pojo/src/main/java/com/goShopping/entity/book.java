package com.goShopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class book {
      private int id;
      private String name;
      private String author;
      private String publisher;
      private int price;
      private String image;
      private int originalPrice;
      private String detail;
      private String category;
      private String describe;
      private Double rate;
      private int comment;
      private int format;
      private int pages;
      private int discount;
}
