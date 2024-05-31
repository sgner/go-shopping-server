package com.goShopping.mapper;

import com.goShopping.vo.LongTermEventBookHeadItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface EventsMapper {
    @Select("select id,image,`describe`,price,original_price,detail,discount,rate,comment from book where event=#{eventId}")
    public ArrayList<LongTermEventBookHeadItemVO> longTermEvent(int eventId);
}
