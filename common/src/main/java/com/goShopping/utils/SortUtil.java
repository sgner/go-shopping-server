package com.goShopping.utils;

import com.goShopping.constant.SortConstant;
import lombok.Getter;

import java.util.HashMap;

public class SortUtil {
    @Getter
    private static final HashMap<Integer,String> sort = new HashMap<>();
    static {
        sort.put(1, SortConstant.SORT_ASC);
        sort.put(2,SortConstant.SORT_DESC);;
    }

}
