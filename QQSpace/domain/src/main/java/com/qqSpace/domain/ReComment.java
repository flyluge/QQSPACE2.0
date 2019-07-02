package com.qqSpace.domain;

import java.sql.Timestamp;
public class ReComment {
    private Integer rmid;
  // private Integer uid;
    private User user;
    //private Integer cid;
    private Comment comment;
    private String content;
    private Timestamp pubdate;

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    /*public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }*/
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
    
}
