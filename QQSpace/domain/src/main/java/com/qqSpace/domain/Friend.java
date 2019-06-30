package com.qqSpace.domain;

import java.util.Objects;

public class Friend {
    private Integer fid;
    private Integer tuid;
    private Integer fuid;
    private Integer status;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(fid, friend.fid) &&
                Objects.equals(tuid, friend.tuid) &&
                Objects.equals(fuid, friend.fuid) &&
                Objects.equals(status, friend.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, tuid, fuid, status);
    }
}
