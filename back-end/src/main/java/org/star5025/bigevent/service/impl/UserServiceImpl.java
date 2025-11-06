package org.star5025.bigevent.service.impl;

import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForLocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.star5025.bigevent.mapper.UserMapper;
import org.star5025.bigevent.pojo.User;
import org.star5025.bigevent.service.UserService;
import org.star5025.bigevent.utils.Md5Util;
import org.star5025.bigevent.utils.ThreadLocalUtil;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        //密码加密，调用MD5加密算法
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username, md5String);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd), id);
    }
}
