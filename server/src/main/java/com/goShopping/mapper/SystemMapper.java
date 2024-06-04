package com.goShopping.mapper;

import com.goShopping.entity.Book;
import com.goShopping.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SystemMapper {
    @Select("select id,`describe`,discount,image,original_price,price from book")
    public ArrayList<RecommendBookVO> getRecommendBook();
    @Select("select * from book where id=#{id}")
    Book getBook(int id);
    @Select("select * from comment where book_id =#{id}")
    ArrayList<BookCommentVO> getBookComment(int id);
    @Select("select * from copyright where book_id=#{id}")
    CopyrightVO getCopyright(int id);
    @Select("select * from other_message")
    ArrayList<MessageVO> getMessage(int id);
    @Select("select * from content where message_id =#{messageId}")
    ArrayList<ContentVO> getContent(int messageId);
    @Select("select image, name, author, published_date, publisher, price, discount, original_price, detail from book where name like concat('%',#{message},'%') ")
    List<SearchBookResultVO> searchBookByName(String message);
    @Select("select * from book where author like concat('%',#{message},'%')")
    List<SearchBookResultVO> searchBookByAuthor(String message);
    @Select("select * from book where publisher like concat('%',#{message},'%')")
    List<SearchBookResultVO> searchBookByPublisher(String message);
     @Select("select * from book where author like concat('%',#{message},'%')")
    List<SearchBookResultVO> searchBookByAuthorSort(String message, Integer basis,);
}
