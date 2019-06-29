package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class ReMessageboard {
    private int rmid;
    private Integer uid;
    private Integer mbid;
    private String content;
    private Timestamp pubdate;
    private User userByUid;
    private Messageboard messageboardByMbid;

    public int getRmid() {
        return rmid;
    }

    public void setRmid(int rmid) {
        this.rmid = rmid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMbid() {
        return mbid;
    }

    public void setMbid(Integer mbid) {
        this.mbid = mbid;
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
        ReMessageboard that = (ReMessageboard) o;
        return rmid == that.rmid &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(mbid, that.mbid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(pubdate, that.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmid, uid, mbid, content, pubdate);
    }

    public User getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(User userByUid) {
        this.userByUid = userByUid;
    }

    public Messageboard getMessageboardByMbid() {
        return messageboardByMbid;
    }

    public void setMessageboardByMbid(Messageboard messageboardByMbid) {
        this.messageboardByMbid = messageboardByMbid;
    }
}
