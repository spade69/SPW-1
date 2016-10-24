package cn.spw.entity;

/**
 * Created by jiax on 2016/10/12.
 */
public class Articles {
    private int id;
    private String articleUuid;
    private String title;
    private String userUuid;
    private String createTime;
    private String lastUpdateTime;
    private String img;
    private String texts;

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", articleUuid='" + articleUuid + '\'' +
                ", title='" + title + '\'' +
                ", userUuid='" + userUuid + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", img='" + img + '\'' +
                ", texts='" + texts + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleUuid() {
        return articleUuid;
    }

    public void setArticleUuid(String articleUuid) {
        this.articleUuid = articleUuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
}
