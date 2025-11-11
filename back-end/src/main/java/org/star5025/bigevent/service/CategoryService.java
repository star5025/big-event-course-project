package org.star5025.bigevent.service;

import org.springframework.stereotype.Service;
import org.star5025.bigevent.pojo.Category;

import java.util.List;

@Service
public interface CategoryService {

    //列表查询
    List<Category> list();

    //新增分类
    void add(Category category);
}
