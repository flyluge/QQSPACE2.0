package com.qqSpace.domain;

import java.sql.Date;
import java.util.Collection;

public class User {
    private int uid;
    private String useremail;
    private String userpassword;
    private String userphone;
    private String username;
    private Date birthday;
    private String astro;
    private Integer sex;
    private String career;
    private String hometown;
    private Collection<Album> albumsByUid;
    private Collection<Article> articlesByUid;
    private Collection<Comment> commentsByUid;
    private Collection<Friend> friendsByUid;
    private Collection<Messageboard> messageboardsByUid;
    private Collection<Praise> praisesByUid;
    private Collection<ReComment> reCommentsByUid;
    private Collection<ReMessageboard> reMessageboardsByUid;
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAstro() {
        return astro;
    }

    public void setAstro(String astro) {
        this.astro = astro;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public Collection<Album> getAlbumsByUid() {
        return albumsByUid;
    }

    public void setAlbumsByUid(Collection<Album> albumsByUid) {
        this.albumsByUid = albumsByUid;
    }

    public Collection<Article> getArticlesByUid() {
        return articlesByUid;
    }

    public void setArticlesByUid(Collection<Article> articlesByUid) {
        this.articlesByUid = articlesByUid;
    }

    public Collection<Comment> getCommentsByUid() {
        return commentsByUid;
    }

    public void setCommentsByUid(Collection<Comment> commentsByUid) {
        this.commentsByUid = commentsByUid;
    }

    public Collection<Friend> getFriendsByUid() {
        return friendsByUid;
    }

    public void setFriendsByUid(Collection<Friend> friendsByUid) {
        this.friendsByUid = friendsByUid;
    }

    public Collection<Messageboard> getMessageboardsByUid() {
        return messageboardsByUid;
    }

    public void setMessageboardsByUid(Collection<Messageboard> messageboardsByUid) {
        this.messageboardsByUid = messageboardsByUid;
    }

    public Collection<Praise> getPraisesByUid() {
        return praisesByUid;
    }

    public void setPraisesByUid(Collection<Praise> praisesByUid) {
        this.praisesByUid = praisesByUid;
    }

    public Collection<ReComment> getReCommentsByUid() {
        return reCommentsByUid;
    }

    public void setReCommentsByUid(Collection<ReComment> reCommentsByUid) {
        this.reCommentsByUid = reCommentsByUid;
    }

    public Collection<ReMessageboard> getReMessageboardsByUid() {
        return reMessageboardsByUid;
    }

    public void setReMessageboardsByUid(Collection<ReMessageboard> reMessageboardsByUid) {
        this.reMessageboardsByUid = reMessageboardsByUid;
    }
}
