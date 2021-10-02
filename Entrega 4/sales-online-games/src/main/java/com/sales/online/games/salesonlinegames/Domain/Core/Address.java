package com.sales.online.games.salesonlinegames.Domain.Core;

public class Address {
    private long addressId;
    private String publicPlace;
    private String city;
    private String federativeUnit;
    private String zipCode;

    public Address() { }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Address(String publicPlace, String city, String federativeUnit, String zipCode){
        this.publicPlace = publicPlace;
        this.city = city;
        this.federativeUnit = federativeUnit;
        this.zipCode = zipCode;
    }

    public String getPublicPlace() {
        return this.publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFederativeUnit() {
        return this.federativeUnit;
    }

    public void setFederativeUnit(String federativeUnit) {
        this.federativeUnit = federativeUnit;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
