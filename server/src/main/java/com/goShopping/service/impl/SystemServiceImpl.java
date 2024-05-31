package com.goShopping.service.impl;

import com.goShopping.entity.Book;
import com.goShopping.mapper.SystemMapper;
import com.goShopping.result.Result;
import com.goShopping.service.SystemService;
import com.goShopping.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SystemServiceImpl implements SystemService {
@Autowired
SystemMapper systemMapper;
    @Override
    public Result recommend() {
        ArrayList<RecommendBookVO> list = systemMapper.getRecommendBook();
        return Result.success(list);
    }

    @Override
    public Result getBookDetail(int id) {
        Book book = systemMapper.getBook(id);
        ArrayList<BookCommentVO> commentList = systemMapper.getBookComment(id);
        CopyrightVO copyright = systemMapper.getCopyright(id);
        ArrayList<MessageVO>  messages = systemMapper.getMessage(id);
        ArrayList<ContentVO> content = new ArrayList<>();
        for(MessageVO message: messages){
           content = systemMapper.getContent(message.getMessageId());
        }
    }
}
