package fr.natan.cleanarchitectureaddressms.domain.entity;

public class Address {
    private Long addressID;
    private int wayNum;
    private String street;
    private int poBox;
    private String city;
    private String country;

    public Address() {
    }

    public Address(Long addressID, int wayNum, String street, int poBox, String city, String country) {
        this.addressID = addressID;
        this.wayNum = wayNum;
        this.street = street;
        this.poBox = poBox;
        this.city = city;
        this.country = country;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public int getWayNum() {
        return wayNum;
    }

    public void setWayNum(int wayNum) {
        this.wayNum = wayNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPoBox() {
        return poBox;
    }

    public void setPoBox(int poBox) {
        this.poBox = poBox;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
