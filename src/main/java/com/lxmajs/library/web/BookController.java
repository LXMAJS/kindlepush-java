package com.lxmajs.library.web;

import com.lxmajs.library.entity.Book;
import com.lxmajs.library.model.JsonResult;
import com.lxmajs.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获得所有的书籍列表，此处未分
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    private JsonResult bookList(){
        List<Book> list = bookService.getBookList();

        List<Book> newList = list
            .stream ()
            .filter ( b-> new Date ( 2019, 1, 1 ).compareTo ( b.getCreateTime () ) > 0 )
            .collect( Collectors.toList());

        Map<String, Object> data = new HashMap<>();
        data.put("list", list);
        data.put("curpath", System.getProperties());
        return JsonResult.ok(data);
    }

    /**
     * 查询单本书籍
     * @param bookId
     * @return
     */
    @RequestMapping(value = "getbyid", method = RequestMethod.GET)
    private JsonResult getById(Integer bookId){
        Book book = bookService.getBookById(bookId);
        if(book == null)
            return JsonResult.error("找不到此书");
        return JsonResult.ok(book);
    }

    /**
     * 添加书籍
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    private JsonResult addBook(@RequestBody Book book){
        boolean success = bookService.addBook(book);
        if (success)
            return JsonResult.ok();
        else
            return JsonResult.error("添加书籍失败");
    }

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    private JsonResult modifyBook(@RequestBody Book book){
        boolean success = bookService.modifyBook(book);
        if (success)
            return JsonResult.ok();
        else
            return JsonResult.error("书籍更新失败");
    }

    /**
     * 删除某一册书籍
     * @param bookId
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    private JsonResult deleteBook(Integer bookId) {
        boolean success = bookService.deleteBook(bookId);
        if (success)
            return JsonResult.ok();
        else
            return JsonResult.error("书籍删除失败");
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
