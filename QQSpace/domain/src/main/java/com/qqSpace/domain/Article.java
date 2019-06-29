package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class Article {
    private int aid;
    private int uid;
    private String content;
    private String image;
    private Timestamp pubdate;
    private User userByUid;
    private Collection<Comment> commentsByAid;
    private Collection<Praise> praisesByAid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getPubdate() {
        return pubdate;
    }

    public void setPubdate(Timestamp pubdate) {
        this.pubdate = pubdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return aid == article.aid &&
                uid == article.uid &&
                Objects.equals(content, article.content) &&
                Objects.equals(image, article.image) &&
                Objects.equals(pubdate, article.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, uid, content, image, pubdate);
    }

    public User getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(User userByUid) {
        this.userByUid = userByUid;
    }

    public Collection<Comment> getCommentsByAid() {
        return commentsByAid;
    }

    public void setCommentsByAid(Collection<Comment> commentsByAid) {
        this.commentsByAid = commentsByAid;
    }

    public Collection<Praise> getPraisesByAid() {
        return praisesByAid;
    }

    public void setPraisesByAid(Collection<Praise> praisesByAid) {
        this.praisesByAid = praisesByAid;
    }
}
