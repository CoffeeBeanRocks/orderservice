package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class Order {
    private int customerId;
    private double total;
    private Address shippingAddress;

    public Order(int customerId, double total, Address shippingAddress)
    {
        this.customerId = customerId;
        this.total = total;
        this.shippingAddress = shippingAddress;
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
}
