package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Messageboard {
    private Integer mbid;
    private Integer tuid;
    private Integer wuid;
    private String content;
    private Timestamp pubdate;

    public Integer getMbid() {
        return mbid;
    }

    public void setMbid(Integer mbid) {
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
        return Objects.equals(mbid, that.mbid) &&
                Objects.equals(tuid, that.tuid) &&
                Objects.equals(wuid, that.wuid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(pubdate, that.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mbid, tuid, wuid, content, pubdate);
    }
}
