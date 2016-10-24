package cn.spw.service.Impl;

import cn.spw.dao.UserDao;
import cn.spw.entity.User;
import cn.spw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiax on 2016/9/17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean isUsernameExisted(String username) {
        if(userDao.queryByUsername(username) != null) {return true;}
        else {return false;}
    }

    @Override
    public Boolean isEmailExisted(String email) {
        if(userDao.queryByEmail(email) != null) {return true;}
        else {return false;}
    }

    @Override
    public User addUser(User user) {
        userDao.addUser(user);
        return user;
    }

    @Override
    public User validation(User user) {
        User vo = userDao.queryByEmailAndPassword(user);
        if (vo != null) {
            return vo;
        } else {
            return userDao.queryByUsernameAndPassword(user);
        }
    }
}
