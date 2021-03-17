package com.example.recyclelist;

public class Book {

    String name;
    String detail;
    int image;

    public Book(String name, String detail, int image) {
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
