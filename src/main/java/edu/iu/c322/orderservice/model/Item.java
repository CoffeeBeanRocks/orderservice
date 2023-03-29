package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class Item {
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    private int quantity;
    private double price;

    public Item(@Valid String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\"name\": \""+this.name+"\",\n" +
                "\t\"quantity\": \""+this.quantity+"\",\n" +
                "\t\"price\": \""+this.price+"\",\n" +
                "}";
    }
}
