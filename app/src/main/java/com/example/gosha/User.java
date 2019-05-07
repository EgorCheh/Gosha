package com.example.gosha;

import java.util.UUID;

public class User {
    private String Fname;
    private String Sname;
    private String UserInfo;
    private Integer Age;
    private Integer Exp;
    private Integer Level;
    private String Mail;
    private String Pass;
    private UUID id;

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        UserInfo = userInfo;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }


    public Integer getExp() {
        return Exp;
    }

    public void setExp(Integer exp) {
        Exp = exp;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "Fname='" + Fname + '\'' +
                ", Sname='" + Sname + '\'' +
                ", UserInfo='" + UserInfo + '\'' +
                ", Age=" + Age +
                ", Exp=" + Exp +
                ", Level=" + Level +
                ", Mail='" + Mail + '\'' +
                ", Pass='" + Pass + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public User(String fname, String sname, String userInfo, Integer age, Integer exp, Integer level, String mail, String pass) {
        id= UUID.randomUUID();
        Fname = fname;
        Sname = sname;
        UserInfo = userInfo;
        Age = age;
        Exp = exp;
        Level = level;
        Mail = mail;
        Pass = pass;
    }


}
