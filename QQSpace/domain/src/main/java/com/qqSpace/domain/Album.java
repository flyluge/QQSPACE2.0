package com.qqSpace.domain;

import java.util.Objects;

public class Album {
    private Integer alid;
    private Integer uid;
    private String image;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(alid, album.alid) &&
                Objects.equals(uid, album.uid) &&
                Objects.equals(image, album.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alid, uid, image);
    }
}
