package com.qqSpace.domain;

public class Praise {
    private int pid;
    private User userByUid;
    private Article articleByAid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public User getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(User userByUid) {
        this.userByUid = userByUid;
    }

    public Article getArticleByAid() {
        return articleByAid;
    }

    public void setArticleByAid(Article articleByAid) {
        this.articleByAid = articleByAid;
    }
}
