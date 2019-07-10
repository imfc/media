package com.imfc.media.user.service;







import com.alibaba.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {
    static{
        System.err.println("userservice。。。。。");
    }

    @Override
    public Map<String, Object> getUser(String name, String password) {
        Map<String,Object> user = new HashMap<>();
        user.put("name","zhangsan");
        user.put("age","12");
        return user;
    }
}
