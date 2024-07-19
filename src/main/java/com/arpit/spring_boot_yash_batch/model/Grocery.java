package com.arpit.spring_boot_yash_batch.model;

public class Grocery {
    private String name;
    private int quantity;
    private int price;

    public Grocery(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // @Override
    // public String toString() {
    //     return " Name :  " + name + "\nQuantity : " + quantity + "\nPrice : " + price;
    // }

}
