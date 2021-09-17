package com.sales.online.games.salesonlinegames.Model.Support;

public class Address {
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(String name, String streetAddress, String city, String state, String country, String zipCode){
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString()
    {
        return name + ": " + streetAddress + ": " 
                + city + ", " + state + " " + zipCode;
    }
}
