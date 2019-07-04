package com.qqSpace.domain;

import java.sql.Timestamp;

public class Album {
    private Integer alid;
    private Integer uid;
    private String image;
    private Timestamp pubdate;
    
    public Timestamp getPubdate() {
		return pubdate;
	}

	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}

	public Integer getAlid() {
        return alid;
    }

    public void setAlid(Integer alid) {
        this.alid = alid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
