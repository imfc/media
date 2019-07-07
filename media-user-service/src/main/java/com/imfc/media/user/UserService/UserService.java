package com.imfc.media.user.UserService;

import com.alibaba.dubbo.config.annotation.Service;
import com.imfc.meida.user.userService.IUserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {


    @Override
    public Map<String, Object> getUser(String name, String password) {
        Map<String,Object> user = new HashMap<>();
        user.put("name","zhangsan");
        user.put("age","12");
        return user;
    }
}
