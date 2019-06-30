package com.qqSpace.domain;

import java.util.Objects;

public class Praise {
    private Integer pid;
    private Integer uid;
    private Integer aid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Praise praise = (Praise) o;
        return Objects.equals(pid, praise.pid) &&
                Objects.equals(uid, praise.uid) &&
                Objects.equals(aid, praise.aid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, uid, aid);
    }
}
