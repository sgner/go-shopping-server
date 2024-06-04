package com.goShopping.result;

import com.goShopping.vo.SearchBookResultVO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class PageSearchResult {
    Long total;
    List<SearchBookResultVO> books;
}
