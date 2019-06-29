package com.qqSpace.domain;

public class Friend {
    private int fid;
    private Integer status;
    private User userByTuid;//好友拥有者
    private User userByFuid;//好友

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUserByTuid() {
        return userByTuid;
    }

    public void setUserByTuid(User userByTuid) {
        this.userByTuid = userByTuid;
    }

    public User getUserByFuid() {
        return userByFuid;
    }

    public void setUserByFuid(User userByFuid) {
        this.userByFuid = userByFuid;
    }
}
