package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Comment {
    private Integer cid;
    private Integer uid;
    private Integer aid;
    private String content;
    private Timestamp pubdate;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(cid, comment.cid) &&
                Objects.equals(uid, comment.uid) &&
                Objects.equals(aid, comment.aid) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(pubdate, comment.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, aid, content, pubdate);
    }
}
