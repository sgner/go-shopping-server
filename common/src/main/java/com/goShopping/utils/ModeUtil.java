package com.goShopping.utils;

import com.goShopping.constant.ModeConstant;
import lombok.Getter;

import java.util.HashMap;

public class ModeUtil {
    @Getter
    private static final HashMap<Integer,String> searchMode = new HashMap<>();
    static {
        searchMode.put(1, ModeConstant.SEARCH_AUTHOR);
        searchMode.put(2,ModeConstant.SEARCH_NAME);
        searchMode.put(3, ModeConstant.SEARCH_PUBLISHER);
        searchMode.put(4, ModeConstant.SEARCH_CATEGORY);
    }
}
