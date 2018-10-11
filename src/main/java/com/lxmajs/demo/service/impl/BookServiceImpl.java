package com.lxmajs.demo.service.impl;

import com.lxmajs.demo.dao.BookDao;
import com.lxmajs.demo.entity.Book;
import com.lxmajs.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBookList() {
        return bookDao.queryBook();
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDao.queryBookById(bookId);
    }

    @Transactional
    @Override
    public boolean addBook(Book book) {
        // 业务判断
        if(book.getTitle() != null && !"".equals(book.getTitle())) {
            // 设置开始时间
            book.setCreateTime(new Date());
            try {

                int effectedNum = bookDao.insertBook(book);
                if(effectedNum > 0)
                    return true;
                else
                    throw new RuntimeException("插入书籍信息异常！");

            } catch (Exception e) {
                throw new RuntimeException("插入书籍信息失败：" + e.getMessage());
            }
        }

        // else
        throw new RuntimeException("书籍信息不完整！");
    }

    @Override
    public boolean modifyBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(int bookId) {
        return false;
    }
}
