package cn.spw.web;

import cn.spw.common.GetUUIDNumber;
import cn.spw.common.SpwConstants;
import cn.spw.entity.User;
import cn.spw.service.UserService;
import com.google.code.kaptcha.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiax on 2016/6/16.
 */
@Controller
@RequestMapping("/user")     //url：/模块/资源/{id}/细分    /seckill/list
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    HttpServletRequest request;

    // 用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(User user) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 邮箱是否已注册
        //if (userService.isEmailExisted(user.getEmail())) {
        //    jsonMap.put("result", spwConstants.REGISTE_EMAIL_EXIST);
        //} else
        if (user.getEmail() == null) {user.setEmail("0");}

        String userUuid = GetUUIDNumber.createUUIDNumber();     // 获取userUuid
        user.setUserUuid(userUuid);

        if (userService.isUsernameExisted(user.getUsername())) {
            jsonMap.put("result", SpwConstants.REGISTE_USERNAME_EXIST); // 账号是否已注册
        } else {
            User vo = userService.addUser(user);
            if (vo != null) {
                jsonMap.put("user", vo);
                jsonMap.put("result", SpwConstants.REGISTE_SUCCESS);
            } else {
                jsonMap.put("result", SpwConstants.REGISTE_FAIL);
            }
        }

        return jsonMap;
    }

    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(User user, HttpSession session) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        // 获取验证码
        String validateCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        // 对比验证码
        if (user.getValidateCode().toUpperCase().equals(validateCode.toUpperCase())) {
            User vo = userService.validation(user);
            if(vo == null) {    //用户名或密码错误
                jsonMap.put("result", SpwConstants.LOGIN_PASSWORD_ERROR);
            } else {            //登录成功
                jsonMap.put("result", SpwConstants.LOGIN_SUCCESS);
                jsonMap.put("user", user);
            }
        } else {                //验证码错误
            jsonMap.put("result", SpwConstants.LOGIN_VALIDATECODE_ERROR);
        }

        return jsonMap;
    }
}
