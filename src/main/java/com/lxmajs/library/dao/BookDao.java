package com.lxmajs.library.dao;

import com.lxmajs.library.entity.Book;

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
     * @param authorId
     * @return
     */
    Book queryBookByAuthorId(int authorId);

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
