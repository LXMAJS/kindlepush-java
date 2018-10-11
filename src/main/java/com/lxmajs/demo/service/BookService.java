package com.lxmajs.demo.service;

import com.lxmajs.demo.entity.Book;

import java.util.List;

public interface BookService {

    /**
     *
     * @return
     */
    List<Book> getBookList();

    /**
     *
     * @param bookId
     * @return
     */
    Book getBookById(int bookId);

    /**
     *
     * @param book
     * @return
     */
    boolean addBook(Book book);

    /**
     *
     * @param book
     * @return
     */
    boolean modifyBook(Book book);

    /**
     *
     * @param bookId
     * @return
     */
    boolean deleteBook(int bookId);
}
