package org.star5025.bigevent.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSort;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.star5025.bigevent.pojo.Result;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list() {
        return Result.success();
    }
}
