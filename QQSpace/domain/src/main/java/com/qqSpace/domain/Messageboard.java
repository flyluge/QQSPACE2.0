package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class Messageboard {
    private int mbid;
    private Integer tuid;
    private Integer wuid;
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

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public Integer getWuid() {
        return wuid;
    }

    public void setWuid(Integer wuid) {
        this.wuid = wuid;
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
        Messageboard that = (Messageboard) o;
        return mbid == that.mbid &&
                Objects.equals(tuid, that.tuid) &&
                Objects.equals(wuid, that.wuid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(pubdate, that.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mbid, tuid, wuid, content, pubdate);
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
