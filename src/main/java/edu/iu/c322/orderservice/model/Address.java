package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class Address {
    //TODO: Not empty not working
    @NotEmpty(message = "State cannot be empty in an address!")
    private String state;
    @NotEmpty(message = "city cannot be empty in an address!")
    private String city;
    private int postalCode;

    public Address(@Valid String state, @Valid String city, int postalCode)
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
