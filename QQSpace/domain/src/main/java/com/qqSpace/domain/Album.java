package com.qqSpace.domain;

public class Album {
    private Integer alid;
    private String image;
    private Integer uid;//用户
	public Integer getAlid() {
		return alid;
	}
	public void setAlid(Integer alid) {
		this.alid = alid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
    
}
