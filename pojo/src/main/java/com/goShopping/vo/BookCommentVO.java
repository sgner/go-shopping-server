package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class BookCommentVO {
    private Double rate;
    private String comment;
    private LocalDateTime commentTime;
    private int like;
    private int dislike;
}
