package cn.spw.common;

/**
 * Created by jiax on 2016/9/17.
 */
public class SpwConstants {
    // 注册返回值
    public final static int REGISTE_SUCCESS = 0;
    public final static int REGISTE_FAIL    = 1;
    public final static int REGISTE_EMAIL_EXIST = 2;
    public final static int REGISTE_USERNAME_EXIST = 3;

    // 登录返回值
    public final static int LOGIN_SUCCESS = 0;
    public final static int LOGIN_PASSWORD_ERROR = 1;
    public final static int LOGIN_VALIDATECODE_ERROR = 2;

    // 新增articles
    public final static int ADD_ARTICLES_SUCCESS = 0;
    public final static int ADD_ARTICLES_FAIL = 1;

    // 修改articles
    public final static int MODIFY_ARTICLES_SUCCESS = 0;
    public final static int MODIFY_ARTICLES_FAIL = 1;

    // 查找articles
    public final static int GET_ARTICLE_SUCCESS = 0;
    public final static int GET_ARTICLE_FAIL = 1;

    // 删除articles
    public final static int DELETE_ARTICLE_SUCCESS = 0;
    public final static int DELETE_ARTICLE_FAIL = 1;
}
