package com.motiky.themeui;

public class ContactModel {
    int img;
    String name, contact;

    public ContactModel(int img, String name, String contact){
        this.img = img;
        this.name = name;
        this.contact = contact;
    }

    public ContactModel(int img) {
        this(img, "Test user", "9876543211");
    }

    public ContactModel(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}
