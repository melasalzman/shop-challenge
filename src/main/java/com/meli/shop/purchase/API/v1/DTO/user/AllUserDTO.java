package com.meli.shop.purchase.API.v1.DTO.user;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;

import java.util.ArrayList;

public class AllUserDTO {
    private ArrayList<UserDTO> users;

    public ArrayList<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserDTO> users) {
        this.users = users;
    }

    public AllUserDTO(ArrayList<UserDTO> users) {
        this.users = users;
    }

    public AllUserDTO() {
    }
}
