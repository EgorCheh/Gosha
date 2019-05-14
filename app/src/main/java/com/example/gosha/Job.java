package com.example.gosha;

import java.util.UUID;

public class Job {
    private String Title;
    private double Price;
    private String Description;
    private String Address;
    private String Contact;
    private String Mail;
    private UUID id;
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
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

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
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
                ", Price=" + Price +
                ", Description='" + Description + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Mail='" + Mail + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public Job(String title, double price, String description, String address, String contacts, String mail) {
        id =UUID.randomUUID();
        Title = title;
        Price = price;
        Description = description;
        Address = address;
        Contact = contacts;
        Mail = mail;
    }

    public Job() {
    }
}
