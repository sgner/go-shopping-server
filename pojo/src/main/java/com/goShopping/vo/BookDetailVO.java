package com.goShopping.vo;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
@Data
@Builder
public class BookDetailVO {
    private String name;
    private String author;
    private String publisher;
    private Double price;
    private String image;
    private LocalDate publishedDate;
    private Double originalPrice;
    private String detail;
    private String category;
    private String describe;
    private int commentCount;
    private int format;
    private int pages;
    private int rank;
    private Double discount;
    private ArrayList<BookCommentVO> comment;
    private BookExtraMessageVO extra;
}
