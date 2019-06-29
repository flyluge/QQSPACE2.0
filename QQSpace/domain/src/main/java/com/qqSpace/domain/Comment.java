package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Collection;
public class Comment {
    private int cid;
    private String content;
    private Timestamp pubdate;
    private User userByUid;
    private Article articleByAid;
    private Collection<ReComment> reCommentsByCid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPubdate() {
        return pubdate;
    }

    public void setPubdate(Timestamp pubdate) {
        this.pubdate = pubdate;
    }
    public User getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(User userByUid) {
        this.userByUid = userByUid;
    }

    public Article getArticleByAid() {
        return articleByAid;
    }

    public void setArticleByAid(Article articleByAid) {
        this.articleByAid = articleByAid;
    }

    public Collection<ReComment> getReCommentsByCid() {
        return reCommentsByCid;
    }

    public void setReCommentsByCid(Collection<ReComment> reCommentsByCid) {
        this.reCommentsByCid = reCommentsByCid;
    }
}
