package org.star5025.bigevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.star5025.bigevent.pojo.Result;
import org.star5025.bigevent.pojo.User;
import org.star5025.bigevent.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        //查询用户，未查到就注册
        User user = userService.findByUserName(username);
        if (user == null) {
            //用户没有被占用
            //注册
            userService.register(username, password);
            return Result.success();
        } else {
            //用户被占用
            return Result.error("用户名已被占用");
        }
        //注册
    }
}
