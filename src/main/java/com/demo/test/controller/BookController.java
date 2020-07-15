package com.demo.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.test.entity.Book;
import com.demo.test.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@Api(value = "BookController", description = "测试相关接口", produces = MediaType.ALL_VALUE)
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 遍历所有的库，所有的表;
     */
    @ApiOperation(value = "获取book")
    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public List<Book> getItems() {
        return bookService.getBookList();
    }

    /**
     * 遍历单个库下面的所有表；
     *
     * @param id
     */
    @ApiOperation(value = "获取book通过ID")
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getItems(@PathVariable String id) {
        return bookService.getById(id);
    }


    /**
     * 遍历单个库下面的所有表；
     *
     * @param id
     */
    @ApiOperation(value = "master获取book通过ID")
    @RequestMapping(value = "/book1/{id}", method = RequestMethod.GET)
    public Book getItems1(@PathVariable String id) {
        HintManager.getInstance().setMasterRouteOnly();
        return bookService.getById(id);
    }


    @ApiOperation(value = "保存book")
    @RequestMapping(value = "/saveBook", method = RequestMethod.GET)
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
