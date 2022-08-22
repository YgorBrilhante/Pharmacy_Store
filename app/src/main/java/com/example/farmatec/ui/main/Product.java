package com.example.farmatec.ui.main;

public class Product {
    public int id;
    public String title;
    public String price;
    public String image;
    public boolean carrinho;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCarrinho() {
        return carrinho;
    }

    public void setCarrinho(boolean carrinho) {
        this.carrinho = carrinho;
    }
}
