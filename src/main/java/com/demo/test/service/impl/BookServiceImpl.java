package com.demo.test.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.test.entity.Book;
import com.demo.test.mapper.BookMapper;
import com.demo.test.service.BookService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cx
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public List<Book> getBookList() {
        return baseMapper.selectList(Wrappers.<Book>lambdaQuery());
    }

    @Override
    public boolean save(Book book) {
        return super.save(book);
    }

    @Override
    public Book getByIdMaster(String id) {
        //分片键值管理器设置强制路由
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        try {
            return super.getById(id);
        } finally {
            hintManager.close();
        }
    }


}
