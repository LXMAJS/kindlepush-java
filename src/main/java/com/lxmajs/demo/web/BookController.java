package com.lxmajs.demo.web;

import com.lxmajs.demo.entity.Book;
import com.lxmajs.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获得所有的书籍列表，此处未分页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    private Map<String, Object> bookList(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Book> list = bookService.getBookList();

        modelMap.put("bookList", list);
        return modelMap;
    }

    /**
     * 查询单本书籍
     * @param bookId
     * @return
     */
    @RequestMapping(value = "getbyid", method = RequestMethod.GET)
    private Map<String, Object> getById(Integer bookId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Book book = bookService.getBookById(bookId);

        modelMap.put("bookInfo", book);
        return modelMap;
    }

    /**
     * 添加书籍
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    private Map<String, Object> addBook(@RequestBody Book book){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bookService.addBook(book));
        return modelMap;
    }

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    private Map<String, Object> modifyBook(@RequestBody Book book){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bookService.modifyBook(book));
        return modelMap;
    }

    /**
     * 删除某一册书籍
     * @param bookId
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    private Map<String, Object> deleteBook(Integer bookId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", bookService.deleteBook(bookId));
        return modelMap;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double num = 0;
        int[] numArray = new int[nums1.length + nums2.length];



        return num;
    }
}
