package com.example.contact3;

public class ContactModel {
    private String name;
    private String phone;
    private int image;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getImage() {
        return image;
    }

    public ContactModel(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }
}
