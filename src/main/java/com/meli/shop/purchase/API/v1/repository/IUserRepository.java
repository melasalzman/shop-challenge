package com.meli.shop.purchase.API.v1.repository;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IUserRepository {
    void saveUser(UserDTO userDTO) throws Exception;

    UserDTO findUserByName(String name) throws IOException;

    ArrayList<UserDTO> getAllUsers() throws IOException;
}
