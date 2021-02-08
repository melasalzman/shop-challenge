package com.meli.shop.purchase.API.v1.DTO.user;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String birthdate;
    private String userName;
    private AddressDTO address;
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserDTO(Integer id, String name, String surname, String birthdate, String userName, AddressDTO address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.userName = userName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UserDTO() {
    }
}
