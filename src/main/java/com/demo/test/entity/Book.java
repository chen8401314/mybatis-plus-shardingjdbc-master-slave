package com.demo.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author cx
 * @Title class Book
 * @Description: 书籍是实体类
 * @date 2019/7/13 15:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book extends Model<Book> {

    @TableId(type = IdType.UUID)
    private String id;

    private String name;

    private int type;

    private int count;
}
