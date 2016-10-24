package cn.spw.dao;

import cn.spw.entity.Articles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiax on 2016/10/12.
 */
public interface ArticlesDao {
    /**
     * 在数据库中插入新articles数据
     * @param articles
     * @return
     */
    int insertArticles (Articles articles);

    /**
     * 修改articles数据
     * @param articles
     * @return
     */
    int updateArticles (Articles articles);

    /**
     * 根据articleUuid查找articles数据
     * @param articleUuid
     * @return
     */
    Articles queryArticlesByArticleUuid (@Param("articleUuid") String articleUuid);

    /**
     * 根据userUuid查找articleUuid列表
     * @param userUuid
     * @return
     */
    List<Articles> queryArticlesByUserUuid (@Param("userUuid") String userUuid);

    /**
     * 删除articles数据
     * @param userUuid
     * @param articleUuid
     * @return
     */
    int deleteArticles (@Param("userUuid") String userUuid, @Param("articleUuid") String articleUuid);
}
