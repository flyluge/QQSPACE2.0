package com.qqSpace.domain;

import java.sql.Timestamp;

public class ReComment {
    private int rmid;
    private String content;
    private Timestamp pubdate;
    private User userByUid;
    private Comment commentByCid;

    public int getRmid() {
        return rmid;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
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

    public Comment getCommentByCid() {
        return commentByCid;
    }

    public void setCommentByCid(Comment commentByCid) {
        this.commentByCid = commentByCid;
    }
}