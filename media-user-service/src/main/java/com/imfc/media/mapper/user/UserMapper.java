package com.imfc.media.mapper.user;

import com.imfc.media.bean.UmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    UmsUser getUser(String userName, String password);

    UmsUser getUserById(int id);

    int updateUser(UmsUser user);

    int insertUser(UmsUser user);

    int deleteUserById(int id);
}
