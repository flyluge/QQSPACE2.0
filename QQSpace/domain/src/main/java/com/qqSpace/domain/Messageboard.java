package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Collection;
public class Messageboard {
    private int mbid;
    private String content;
    private Timestamp pubdate;
    private User userByTuid;
    private User userByWuid;
    private Collection<ReMessageboard> reMessageboardsByMbid;

    public int getMbid() {
        return mbid;
    }

    public void setMbid(int mbid) {
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

    public User getUserByTuid() {
        return userByTuid;
    }

    public void setUserByTuid(User userByTuid) {
        this.userByTuid = userByTuid;
    }

    public User getUserByWuid() {
        return userByWuid;
    }

    public void setUserByWuid(User userByWuid) {
        this.userByWuid = userByWuid;
    }

    public Collection<ReMessageboard> getReMessageboardsByMbid() {
        return reMessageboardsByMbid;
    }

    public void setReMessageboardsByMbid(Collection<ReMessageboard> reMessageboardsByMbid) {
        this.reMessageboardsByMbid = reMessageboardsByMbid;
    }
}
