package com.qqSpace.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Article {
    private Integer aid;
    private Integer uid;
    private String content;
    private String image;
    private Timestamp pubdate;
    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        Article article = (Article) o;
        return Objects.equals(aid, article.aid) &&
                Objects.equals(uid, article.uid) &&
                Objects.equals(content, article.content) &&
                Objects.equals(image, article.image) &&
                Objects.equals(pubdate, article.pubdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, uid, content, image, pubdate);
    }
}
