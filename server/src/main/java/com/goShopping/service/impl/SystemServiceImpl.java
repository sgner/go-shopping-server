package com.goShopping.service.impl;

import com.goShopping.result.Result;
import com.goShopping.service.SystemService;
import com.goShopping.vo.RecommendBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SystemServiceImpl implements SystemService {
@Autowired

    @Override
    public Result recommend() {
        ArrayList<RecommendBookVO> list = new ArrayList<>();

    }
}
