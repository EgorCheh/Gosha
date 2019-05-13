package com.example.gosha;



public class User {
    private String fname;
    private String sname;
    private String userInfo;
    private String age;
    private Integer exp;
    private Integer level;
    private String mail;
    private String pass;
    private String id;
    private String address;
    private String contact;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", sname='" + sname + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", age=" + age +
                ", exp=" + exp +
                ", level=" + level +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public User(String id,String fname, String sname, String userInfo, String age, Integer exp, Integer level, String mail, String pass) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.userInfo = userInfo;
        this.age = age;
        this.exp = exp;
        this.level = level;
        this.mail = mail;
        this.pass = pass;
    }

    public User() {
    }
}
