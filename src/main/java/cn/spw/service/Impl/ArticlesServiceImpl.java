package cn.spw.service.Impl;

import cn.spw.dao.ArticlesDao;
import cn.spw.entity.Articles;
import cn.spw.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiax on 2016/10/12.
 */
@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService{
    @Autowired
    private ArticlesDao articlesDao;

    @Override
    public Boolean addArticles(Articles articles) {
        if (articlesDao.insertArticles(articles) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyArticles(Articles articles) {
        if (articlesDao.updateArticles(articles) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Articles getArticlesByArticleUuid(String articleUuid) {
        return articlesDao.queryArticlesByArticleUuid(articleUuid);
    }

    @Override
    public List<Articles> getArticlesByUserUuid(String userUuid) {
        return articlesDao.queryArticlesByUserUuid(userUuid);
    }

    @Override
    public Boolean deleteArticles(String userUuid, String articleUuid) {
        if (articlesDao.deleteArticles(userUuid, articleUuid) > 0) {
            return true;
        }
        return false;
    }
}
