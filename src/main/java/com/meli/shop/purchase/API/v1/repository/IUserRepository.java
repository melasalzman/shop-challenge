package com.meli.shop.purchase.API.v1.repository;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;

import java.io.IOException;

public interface IUserRepository {
    void saveUser(UserDTO userDTO) throws IOException;

    AllUserDTO getAllUsers() throws IOException;
}
