package com.learning.springboot.model;

public class Client {
    private String name;
    private boolean active;
    private String email;
    private String phone;

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void activate() {
        this.active = true;
    }
}
