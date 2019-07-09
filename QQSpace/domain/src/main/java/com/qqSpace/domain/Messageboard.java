package com.qqSpace.domain;

import java.sql.Timestamp;
public class Messageboard {
    private Integer mbid;//主码
    private Integer tuid;//留言拥有者
   // private Integer wuid;
   // private User tuser;
    private User wuser;//留言发布者
    private String content;//留言内容
    private Timestamp pubdate;//留言时间

    public Integer getMbid() {
        return mbid;
    }

	public Integer getTuid() {
		return tuid;
	}


	public void setTuid(Integer tuid) {
		this.tuid = tuid;
	}


	public User getWuser() {
		return wuser;
	}

	public void setWuser(User wuser) {
		this.wuser = wuser;
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

}
