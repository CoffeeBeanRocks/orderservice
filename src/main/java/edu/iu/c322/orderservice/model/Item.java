package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class Item {
    @NotEmpty(message = "Item name cannot be empty")
    private String name;
    private int id;
    private double price;

    public Item(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
