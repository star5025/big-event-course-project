package org.star5025.bigevent.controller;

//import com.github.xiaoymin.knife4j.annotations.ApiOperationSort;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.ognl.ASTProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.star5025.bigevent.pojo.Result;
import org.star5025.bigevent.pojo.User;
import org.star5025.bigevent.service.UserService;
import org.star5025.bigevent.utils.JwtUtil;
import org.star5025.bigevent.utils.Md5Util;
import org.star5025.bigevent.utils.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^$\\S{5,16}$")String username, @Pattern(regexp = "^$\\S{5,16}$")String password) {
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
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^$\\S{5,16}$")String username, @Pattern(regexp = "^$\\S{5,16}$")String password) {
        //根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        //判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
//          //生成token
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
