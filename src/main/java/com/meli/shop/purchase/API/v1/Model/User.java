package com.meli.shop.purchase.API.v1.Model;


public class User {
    private String name;
    private String surname;
    private String birthdate;
    private String userName;
    private Address address;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String surname, String birthdate, String userName, Address address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.userName = userName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }
}
