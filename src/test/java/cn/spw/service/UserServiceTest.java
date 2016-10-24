package cn.spw.service;

import cn.spw.dao.UserDao;
import cn.spw.entity.User;
import cn.spw.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/9/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void isEmailExisted() throws Exception {
        System.out.println(userService.isEmailExisted("12344@spw.com"));
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUsername("1");
        user.setPassword("0");
        user.setEmail("123@456.com");
        userService.addUser(user);
    }

    @Test
    public void validation() throws Exception {
        User user = new User();
        user.setPassword("0");
        user.setEmail("123@456.com");
        System.out.println(userService.validation(user));
    }
}