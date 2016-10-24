package cn.spw.service;

import cn.spw.entity.Articles;

import java.util.List;

/**
 * Created by jiax on 2016/10/12.
 */
public interface ArticlesService {
    /**
     * 添加articles列
     * @param articles
     * @return
     */
    Boolean addArticles (Articles articles);

    /**
     * 修改articles列
     * @param articles
     * @return
     */
    Boolean modifyArticles (Articles articles);

    /**
     * 根据articleUuid查找article
     * @param articleUuid
     * @return
     */
    Articles getArticlesByArticleUuid (String articleUuid);

    /**
     * 根据userUuid查找articleUuid列表
     * @param userUuid
     * @return
     */
    List<Articles> getArticlesByUserUuid (String userUuid);

    /**
     * 删除articles列
     * @param userUuid
     * @param articleUuid
     * @return
     */
    Boolean deleteArticles (String userUuid, String articleUuid);
}
