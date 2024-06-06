package com.goShopping.service.impl;

import com.goShopping.mapper.EventsMapper;
import com.goShopping.result.Result;
import com.goShopping.service.EventsService;
import com.goShopping.vo.LongTermEventBookBodyItemVO;
import com.goShopping.vo.LongTermEventBookHeadItemVO;
import com.goShopping.vo.LongTermEventVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class EventsServiceImpl implements EventsService {
    @Autowired
    EventsMapper eventsMapper;
    @Override
    public Result longTermEvent(int eventId) {
        ArrayList<LongTermEventBookHeadItemVO> longTermEventBookHeadItem = eventsMapper.longTermEvent(eventId);
        if(longTermEventBookHeadItem.isEmpty()){
            return Result.error("没有书籍，请联系管理员");
        }
        ArrayList<LongTermEventBookBodyItemVO> list = new ArrayList<>();
        for(int i=1;i<longTermEventBookHeadItem.size();i++){
            LongTermEventBookBodyItemVO longTermEventBookBodyItem = new LongTermEventBookBodyItemVO();
            BeanUtils.copyProperties(longTermEventBookHeadItem.get(i),longTermEventBookBodyItem);
            list.add(longTermEventBookBodyItem);
        }
        LongTermEventVO result = LongTermEventVO.builder().head(longTermEventBookHeadItem.get(0)).body(list).build();
        return Result.success(result);
    }
}
