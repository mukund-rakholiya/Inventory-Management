package com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Embeddables;

import jakarta.persistence.*;

@Embeddable
public class Address {
    private int houseNo;
    private String society;
    private String area;
    private String city;
    private int pinCode;

    public Address() {
    }

    public Address(int houseNo, String society, String area, String city, int pinCode) {

        this.houseNo = houseNo;
        this.society = society;
        this.area = area;
        this.city = city;
        this.pinCode = pinCode;
    }


    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
