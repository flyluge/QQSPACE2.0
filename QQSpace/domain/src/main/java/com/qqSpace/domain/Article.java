package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Collection;

public class Article {
    private int aid;
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
