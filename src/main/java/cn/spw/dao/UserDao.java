package cn.spw.dao;

import cn.spw.entity.User;

/**
 * Created by jiax on 2016/9/17.
 */
public interface UserDao {
    void addUser(User user);
    User queryByEmail(String email);
    User queryByUsername(String username);
    User queryByEmailAndPassword(User user);
    User queryByUsernameAndPassword(User user);
}
