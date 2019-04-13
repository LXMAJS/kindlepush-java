package com.lxmajs.library.service.impl;

import com.lxmajs.library.dao.BookDao;
import com.lxmajs.library.entity.Book;
import com.lxmajs.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class BookServiceImpl implements BookService {
    /**
     *
     */
    @Autowired
    private BookDao bookDao;

    /**
     *
     * @return
     */
    @Override
    public List<Book> getBookList() {
        return bookDao.queryBook();
    }

    /**
     *
     * @param bookId
     * @return
     */
    @Override
    public Book getBookById(int bookId) {
        return bookDao.queryBookById(bookId);
    }

    /**
     *
     * @param authorId
     * @return
     */
    @Override
    public Book queryBookByAuthorId(int authorId) { return bookDao.queryBookByAuthorId(authorId);}

    /**
     *
     * @param book
     * @return
     */
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

    /**
     *
     * @param book
     * @return
     */
    @Transactional
    @Override
    public boolean modifyBook(Book book) {
        // 业务判断
        if(book.getTitle() != null && !"".equals(book.getTitle()) && book.getPrice() != null && book.getPrice() >= 0) {
            try {
                book.setLastEditTime(new Date());
                int effectedNum = bookDao.updateBook(book);
                if(effectedNum > 0)
                    return true;
                else
                    throw new RuntimeException("更新书籍信息异常！");

            } catch (Exception e) {
                throw new RuntimeException("更新书籍信息失败：" + e.getMessage());
            }
        }

        // else
        throw new RuntimeException("书籍信息不完整！");
    }

    /**
     *
     * @param bookId
     * @return
     */
    @Transactional
    @Override
    public boolean deleteBook(int bookId) {
        if(bookId > 0){
            try {
                int effectedNum = bookDao.deleteBook(bookId);
                if(effectedNum > 0)
                    return true;
                else
                    throw new RuntimeException("删除书籍信息异常！");

            } catch (Exception e) {
                throw new RuntimeException("删除书籍信息失败：" + e.getMessage());
            }
        }
        // else
        throw new RuntimeException("未找到相关书籍！");
    }
}
