package com.goShopping.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
@Data
@Builder
public class newArrivalSpecialVO {
          private LongTermEventBookHeadItemVO head;
          private ArrayList<LongTermEventBookBodyItemVO> body;
}
