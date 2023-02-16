package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models;

public class AddressDto{
    private int wayNum;
    private String street;
    private int poBox;
    private String city;
    private String country;

    public AddressDto() {
    }

    public AddressDto(int wayNum, String street, int poBox, String city, String country) {
        this.wayNum = wayNum;
        this.street = street;
        this.poBox = poBox;
        this.city = city;
        this.country = country;
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
