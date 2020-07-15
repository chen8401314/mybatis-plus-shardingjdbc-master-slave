package com.demo.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.test.entity.Book;

import java.util.List;

/**
 * @author cx
 * @Title interface BookService
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
public interface BookService extends IService<Book> {

    /**
     * 保存书籍信息
     *
     * @param book
     * @return
     */
    @Override
    boolean save(Book book);

    /**
     * 查询全部书籍信息
     *
     * @return
     */
    List<Book> getBookList();


    Book getByIdMaster(String id);
}
