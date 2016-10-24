package cn.spw.web;

import cn.spw.common.GetUUIDNumber;
import cn.spw.common.SpwConstants;
import cn.spw.entity.Articles;
import cn.spw.service.ArticlesService;
import cn.spw.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/10/12.
 */
@Controller
@ResponseBody
@RequestMapping("")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Map<String, Object> addArticle(Articles articles) {
        JSONObject jsonObject = new JSONObject();

        String articleUuid = GetUUIDNumber.createUUIDNumber();      // 获取ArticleUuid
        articles.setArticleUuid(articleUuid);                       // 设置ArticleUuid

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        articles.setCreateTime(nowTime);        // 设置CreateTime
        articles.setLastUpdateTime(nowTime);    // 设置LastUpdateTime

        if (articlesService.addArticles(articles)) {
            jsonObject.put("result", SpwConstants.ADD_ARTICLES_SUCCESS);
            jsonObject.put("articleUuid", articleUuid);
        } else {
            jsonObject.put("result", SpwConstants.ADD_ARTICLES_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/article", method = RequestMethod.PUT)
    public Map<String, Object> modifyArticle(Articles articles) {
        JSONObject jsonObject = new JSONObject();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        articles.setLastUpdateTime(simpleDateFormat.format(new Date()));    // 设置CreateTime

        if (articlesService.modifyArticles(articles)) {
            jsonObject.put("result", SpwConstants.MODIFY_ARTICLES_SUCCESS);
        } else {
            jsonObject.put("result", SpwConstants.MODIFY_ARTICLES_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/article/{articleUuid}", method = RequestMethod.GET)
    public Map<String, Object> getArticle(@PathVariable("articleUuid") String articleUuid) {
        JSONObject jsonObject = new JSONObject();

        Articles articles = articlesService.getArticlesByArticleUuid(articleUuid);  // 查询articles

        if (articles != null) {     // 获取到数据
            jsonObject.put("result", SpwConstants.GET_ARTICLE_SUCCESS);
            jsonObject.put("article", articles);
        } else {
            jsonObject.put("result", SpwConstants.GET_ARTICLE_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/articleList/{userUuid}", method = RequestMethod.GET)
    public Map<String, Object> getArticleList(@PathVariable("userUuid") String userUuid) {
        JSONObject jsonObject = new JSONObject();

        List<Articles> articlesList = articlesService.getArticlesByUserUuid(userUuid);  // 查询articles

        if (!articlesList.isEmpty()) {     // 获取到数据
            jsonObject.put("result", SpwConstants.GET_ARTICLE_SUCCESS);
            jsonObject.put("listLength", articlesList.size());
            jsonObject.put("articleList", articlesList);
        } else {
            jsonObject.put("result", SpwConstants.GET_ARTICLE_FAIL);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/{userUuid}/{articleUuid}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteArticle(@PathVariable("userUuid") String userUuid, @PathVariable("articleUuid") String articleUuid) {
        JSONObject jsonObject = new JSONObject();

        if (articlesService.deleteArticles(userUuid, articleUuid)) {
            jsonObject.put("result", SpwConstants.DELETE_ARTICLE_SUCCESS);
        } else {
            jsonObject.put("result", SpwConstants.DELETE_ARTICLE_FAIL);
        }

        return jsonObject;
    }
}
