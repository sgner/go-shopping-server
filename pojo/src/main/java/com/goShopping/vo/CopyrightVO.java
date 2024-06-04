package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
@Data
@Builder
public class CopyrightVO {
    private String ISBN;
    private String barcode;
    private String binding;
    private String category;
    private Integer numberOfVolumes;
    private Integer weight;
}
