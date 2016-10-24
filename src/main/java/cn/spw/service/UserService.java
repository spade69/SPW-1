package cn.spw.service;

import cn.spw.entity.User;

/**
 * Created by jiax on 2016/9/17.
 */
public interface UserService {
    Boolean isUsernameExisted(String username);
    Boolean isEmailExisted(String email);
    User addUser(User user);
    User validation(User user);
}
