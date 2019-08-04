package com.thjava.m;

public class Books {
    
    private int id;
    private String title;
    private int price;

    public Books() {
    }

    public Books(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Books(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", title=" + title + ", price=" + price + '}';
    }
    
} // class Books


