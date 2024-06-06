package com.goShopping.service;

import com.goShopping.result.Result;
import com.goShopping.vo.RecommendBookVO;

import java.util.ArrayList;

public interface SystemService {
    Result recommend(int pageNum);

    Result getBookDetail(int id);

    Result getCategories(Integer id);
}
