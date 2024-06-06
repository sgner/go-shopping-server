package com.goShopping.utils;

import com.goShopping.constant.BasisConstant;
import lombok.Getter;

import java.util.HashMap;

public class BasisUtil {
      @Getter
      private static final HashMap<Integer,String> basis = new HashMap<Integer,String>();
      static {
        basis.put(1, BasisConstant.ORIGINAL_PRICE);
        basis.put(2,BasisConstant.DISCOUNT);
        basis.put(3,BasisConstant.PRICE);
        basis.put(4,BasisConstant.PUBLISHED_DATE);
      }
}
