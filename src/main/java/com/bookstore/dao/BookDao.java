package com.bookstore.dao;

import com.bookstore.beans.Book;
import com.bookstore.beans.Page;

import java.sql.Connection;
import java.util.List;

/**
 * @author hongxiaozheng
 * @date 2021/9/23 23:07
 */
public interface BookDao {
    //增
    void saveBook(Connection conn, Book book);
    //删
    void deleteBookById(Connection conn,String bookId);
    //改
    void updateBook(Connection conn,Book book);
    //查
    //查一本书
    Book getBookById(Connection conn,String bookId);
    //查所有
    List<Book> getBooks(Connection conn);
    //有条件地查一部份书
    Page<Book> getPageBooks(Connection conn, Page<Book> page);
    //根据价格查书
    Page<Book> getPageBooksByPrice(Connection conn,Page<Book> page, double
            minPrice, double maxPrice);
}
