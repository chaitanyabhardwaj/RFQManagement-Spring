package com.mrfq.rfqmodule.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Supplier {

    private Long id;
    private String name;
    private String location;
    private String email;
    private String phone;
    private int feedback;

    public Supplier(String name, String location, String email, String phone, int feedback) {
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

}
