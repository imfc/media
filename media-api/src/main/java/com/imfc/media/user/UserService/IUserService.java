package com.imfc.media.user.UserService;

import java.util.Map;

public interface IUserService {
    Map<String, Object> getUser(String name, String password);
}
