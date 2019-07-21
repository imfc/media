package com.imfc.media.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.imfc.media.bean.UmsUser;
import com.imfc.media.mapper.user.UserMapper;
import com.imfc.media.userSys.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Override
    public UmsUser getUser(String name, String password) {
        return userMapper.getUser(name,password);
    }

    @Override
    public UmsUser getUser(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public Integer createUser(UmsUser user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer updateUser(UmsUser user) {
        return userMapper.updateUser(user);
    }
}
