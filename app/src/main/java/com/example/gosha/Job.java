package com.example.gosha;

public class Job {
    private String Title;
    private Float Price;
    private String Description;
    private String Address;
    private String ContactInfo;
    private String Mail;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Float getSalary() {
        return Price;
    }

    public void setSalary(Float salary) {
        Price = salary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    @Override
    public String toString() {
        return "Job{" +

                ", Title='" + Title + '\'' +
                ", Salary=" + Price +
                ", Description='" + Description + '\'' +
                ", Address='" + Address + '\'' +
                ", ContactInfo='" + ContactInfo + '\'' +
                ", Mail='" + Mail + '\'' +
                '}';
    }

    public Job(String title, Float salary, String description, String address, String contactInfo, String mail) {
        Title = title;
        Price = salary;
        Description = description;
        Address = address;
        ContactInfo = contactInfo;
        Mail = mail;
    }

    public Job() {
    }
}
