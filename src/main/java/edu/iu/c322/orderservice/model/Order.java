package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

public class Order {
    private int customerId;
    private double total;
    private Address shippingAddress;
    private List<Item> items;
    private Payment payment;

    public Order(int customerId, double total, @Valid Address shippingAddress, List<Item> items, @Valid Payment payment)
    {
        this.customerId = customerId;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.payment = payment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
