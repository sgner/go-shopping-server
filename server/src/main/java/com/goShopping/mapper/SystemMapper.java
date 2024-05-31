package com.goShopping.mapper;

import com.goShopping.entity.Book;
import com.goShopping.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface SystemMapper {
    @Select("select id,`describe`,image,originalPrice,price from book")
    public ArrayList<RecommendBookVO> getRecommendBook();
    @Select("select * from book where id=#{id}")
    Book getBook(int id);
    @Select("select * from comment where bookId =#{id}")
    ArrayList<BookCommentVO> getBookComment(int id);
    @Select("select * from copyright where bookId=#{id}")
    CopyrightVO getCopyright(int id);
    @Select("select * from other_message")
    ArrayList<MessageVO> getMessage(int id);
    @Select("select * from content where message_id =#{messageId}")
    ArrayList<ContentVO> getContent(int messageId);
}
