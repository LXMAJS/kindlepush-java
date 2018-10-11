package com.lxmajs.demo.dao;

import com.lxmajs.demo.entity.Book;

import java.util.List;


public interface BookDao {

    /**
     *
     * @return
     */
    List<Book> queryBook();

    /**
     *
     * @param bookId
     * @return
     */
    Book queryBookById(int bookId);

    /**
     *
     * @param book
     * @return
     */
    int insertBook(Book book);

    /**
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     *
     * @param bookId
     * @return
     */
    int deleteBook(int bookId);

}
