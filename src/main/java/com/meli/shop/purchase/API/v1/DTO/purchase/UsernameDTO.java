package com.meli.shop.purchase.API.v1.DTO.purchase;

public class UsernameDTO {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsernameDTO(String username) {
        this.username = username;
    }

    public UsernameDTO() {
    }
}
