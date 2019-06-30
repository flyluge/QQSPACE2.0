package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class ReComment {
    private Integer rmid;
    private Integer uid;
    private Integer cid;
    private String content;
    private Timestamp pubdate;

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReComment reComment = (ReComment) o;
        return Objects.equals(rmid, reComment.rmid) &&
                Objects.equals(uid, reComment.uid) &&
                Objects.equals(cid, reComment.cid) &&
                Objects.equals(content, reComment.content) &&
                Objects.equals(pubdate, reComment.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmid, uid, cid, content, pubdate);
    }
}
