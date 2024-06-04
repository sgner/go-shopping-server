package com.goShopping.result;

import com.goShopping.vo.RecommendBookVO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageResult {
    private Long total;
    private List<RecommendBookVO> recommendBookVO;
}
