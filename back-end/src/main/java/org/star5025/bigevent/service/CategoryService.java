package org.star5025.bigevent.service;

import org.springframework.stereotype.Service;
import org.star5025.bigevent.pojo.Category;

@Service
public interface CategoryService {

    //新增分类
    void add(Category category);
}
