package edu.iu.c322.orderservice.model;

public class Address {
    private String state;
    private String city;
    private int postalCode;

    public Address(String state, String city, int postalCode)
    {
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
