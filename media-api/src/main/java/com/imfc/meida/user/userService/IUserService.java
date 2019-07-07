package com.imfc.meida.user.userService;

import java.util.Map;

public interface IUserService {

    Map<String,Object> getUser(String name, String password);
}
