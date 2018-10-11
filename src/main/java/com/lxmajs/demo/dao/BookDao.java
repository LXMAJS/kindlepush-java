package com.lxmajs.demo.dao;

import com.lxmajs.demo.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     *
     * @return
     */
    List<Book> query();

    /**
     *
     * @param bookId
     * @return
     */
    Book queryById(int bookId);

    /**
     *
     * @param book
     * @return
     */
    int insert(Book book);

    /**
     *
     * @param book
     * @return
     */
    int update(Book book);

    /**
     * 
     * @param bookId
     * @return
     */
    int delete(int bookId);

}
