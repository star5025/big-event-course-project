package org.star5025.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.star5025.bigevent.pojo.Category;
import org.star5025.bigevent.pojo.Result;
import org.star5025.bigevent.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }
}