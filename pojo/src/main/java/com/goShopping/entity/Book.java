package com.goShopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
      private Integer id;
      private String name;
      private String author;
      private String publisher;
      private LocalDate publishedDate;
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
      private int rank;
}
