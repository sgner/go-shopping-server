package com.goShopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
      private int id;
      private String name;
      private String author;
      private String publisher;
      private Double price;
      private String image;
      private Double originalPrice;
      private String detail;
      private String category;
      private String describe;
      private Double rate;
      private int comment;
      private int format;
      private int pages;
      private Double discount;
      private int event;
      private boolean status;
}
