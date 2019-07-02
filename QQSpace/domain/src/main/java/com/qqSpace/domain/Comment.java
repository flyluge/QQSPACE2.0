package com.qqSpace.domain;

import java.sql.Timestamp;

public class Comment {
    private Integer cid;
   // private Integer uid;
    private User user;//发表评论的用户
    private Integer aid;
    private String content;
    private Timestamp pubdate;

    public Integer getCid() {
        return cid;
    }
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCid(Integer cid) {
        this.cid = cid;
    }

  /*  public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }*/

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
}
