package com.qqSpace.domain;

import java.sql.Date;
import java.util.Objects;

public class User {
    private Integer uid;
    private String useremail;
    private String userpassword;
    private String userphone;
    private String username;
    private Date birthday;
    private String astro;
    private Integer sex;
    private String career;
    private String hometown;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) &&
                Objects.equals(useremail, user.useremail) &&
                Objects.equals(userpassword, user.userpassword) &&
                Objects.equals(userphone, user.userphone) &&
                Objects.equals(username, user.username) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(astro, user.astro) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(career, user.career) &&
                Objects.equals(hometown, user.hometown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, useremail, userpassword, userphone, username, birthday, astro, sex, career, hometown);
    }
}
