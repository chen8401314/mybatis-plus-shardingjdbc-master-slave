package com.demo.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.test.entity.Book;
import com.demo.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author cx
 * @Title class BookController
 * @Description: TODO
 * @date 2019/7/12 20:53
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 遍历所有的库，所有的表;
     */
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> getItems() {
        return bookService.getBookList();
    }

    /**
     * 遍历单个库下面的所有表；
     *
     * @param id
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getItems(@PathVariable String id) {
        return bookService.getById(id);
    }



    /**
     * @param type
     * @return 直接定位到单个数据下的，单个表；
     */
    @RequestMapping(value = "/bookt/{type}", method = RequestMethod.GET)
    public List<Book> getItems(@PathVariable Integer type) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        return bookService.list(queryWrapper);
    }


    /**
     * 遍历所有数据库的 单个表；
     *
     * @param count
     * @return
     */
    @RequestMapping(value = "/bookc/{count}", method = RequestMethod.GET)
    public List<Book> getItemsCount(@PathVariable Integer count) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("count", count);
        return bookService.list(queryWrapper);
    }

    /**
     * 遍历所有数据库的 单个表；
     *
     * @param count
     * @return
     */
    @RequestMapping(value = "/booktc/{type}/{count}", method = RequestMethod.GET)
    public List<Book> getItemsCount(@PathVariable Integer type,@PathVariable Integer count) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", type);
        queryWrapper.eq("count", count);
        return bookService.list(queryWrapper);
    }


    @RequestMapping(value = "/book1", method = RequestMethod.GET)
    public Boolean saveItem() {
        Book book = new Book();
        Random r = new Random();
        book.setName("book" + r.nextInt(100));
        book.setCount(r.nextInt(100));
        book.setType(r.nextInt(3));
        return bookService.save(book);
    }

  /*  @RequestMapping(value = "/book2", method = RequestMethod.GET)
    public Boolean save2Item() {
        List<Book> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book();
            Random r = new Random();
            book.setName("book" + r.nextInt(100));
            book.setCount(r.nextInt(100));
            book.setType(r.nextInt(3));
            list.add(book);
        }
        return bookService.saveBatch(list);
    }*/

}
