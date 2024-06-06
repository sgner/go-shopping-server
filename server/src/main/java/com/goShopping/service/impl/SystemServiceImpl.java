package com.goShopping.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.goShopping.entity.Book;
import com.goShopping.mapper.SystemMapper;
import com.goShopping.properties.PageProperties;
import com.goShopping.result.PageResult;
import com.goShopping.result.Result;
import com.goShopping.service.SystemService;
import com.goShopping.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
@Autowired
SystemMapper systemMapper;
@Autowired
    PageProperties pageProperties;
    @Override
    public Result recommend(int pageNum) {
        PageHelper.startPage(pageNum,pageProperties.getPageSize());
        Page<RecommendBookVO> page = (Page<RecommendBookVO>) systemMapper.getRecommendBook();
        return Result.success(PageResult.builder().recommendBookVO(page.getResult()).total(page.getTotal()).build());
    }

    @Override
    public Result getBookDetail(int id) {
        Book book = systemMapper.getBook(id);
        ArrayList<BookCommentVO> commentList = systemMapper.getBookComment(id);
        CopyrightVO copyright = systemMapper.getCopyright(id);
        ArrayList<MessageVO>  messages = systemMapper.getMessage(id);
        ArrayList<ContentVO> content = new ArrayList<>();
        ArrayList<BookOtherMessageVO> otherMessage = new ArrayList<>();

        for(MessageVO message: messages){
           content = systemMapper.getContent(message.getMessageId());
           BookOtherMessageVO bookOtherMessageVO = BookOtherMessageVO.builder().title(message.getTitle()).content(content).build();
           otherMessage.add(bookOtherMessageVO);
        }
        BookExtraMessageVO extraMessage = BookExtraMessageVO.builder().copyright(copyright).otherMessage(otherMessage).build();

        BookDetailVO bookDetail = BookDetailVO.builder().comment(commentList).extra(extraMessage).build();
        BeanUtils.copyProperties(book,bookDetail);
        return Result.success(bookDetail);
    }

    @Override
    public Result getCategories(Integer id) {
          List<AllCategoryVO>categories =  systemMapper.getCategories(id);
          return Result.success(categories);
    }


}
