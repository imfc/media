package com.imfc.media.userSys.service.user;

import com.imfc.media.bean.UmsUser;


public interface IUserService {
    /* *
     * @Author luxiaojian
     * @Description 根据用户名和密码获取用户信息，用于：用户登录
     * @Date 11:40 2019/7/21
     * @Param [name, password]
     * @return com.imfc.media.bean.UmsUser
     **/
     UmsUser getUser(String name, String password);

     /* *
      * @Author luxiaojian
      * @Description 根据用户编号获取用户详情
      * @Date 18:09 2019/7/21
      * @Param [id]
      * @return com.imfc.media.bean.UmsUser
      **/
     UmsUser getUser(Integer id);

     /* *
     * @Author luxiaojian
     * @Description 创建一个用户
     * @Date 18:06 2019/7/21
     * @Param [user]
     * @return java.lang.Integer
     **/
     Integer createUser(UmsUser user);

     /* *
      * @Author luxiaojian
      * @Description 修改用户信息
      * @Date 18:10 2019/7/21
      * @Param [user]
      * @return java.lang.Integer
      **/
     Integer updateUser(UmsUser user);

}
