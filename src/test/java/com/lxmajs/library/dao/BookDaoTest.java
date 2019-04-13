package com.lxmajs.library.dao;

import com.lxmajs.library.entity.Book;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void queryBook() {
        List<Book> bookList = bookDao.queryBook();
        assertEquals(2, bookList.size());
    }

    @Test
    @Ignore
    public void queryBookById() {
        Book book = bookDao.queryBookById(1);
        assertEquals("唐诗三百首", book.getTitle());
    }

    @Test
    @Ignore
    public void insertBook() {
    }

    @Test
    @Ignore
    public void updateBook() {
    }

    @Test
    @Ignore
    public void deleteBook() {
    }
}