package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;

import java.io.IOException;

public interface IUserService {

    void createUser(UserDTO userDTO) throws IOException;

    AllUserDTO getAllUsers(UserFilterDTO userFilterDTO) throws IOException;
}
