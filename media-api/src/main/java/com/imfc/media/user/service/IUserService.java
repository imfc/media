package com.imfc.media.user.service;

import java.util.Map;

public interface IUserService {
    Map<String, Object> getUser(String name, String password);
}
