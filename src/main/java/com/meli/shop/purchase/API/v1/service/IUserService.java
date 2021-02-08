package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserFilterDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IUserService {

    void createUser(UserDTO userDTO) throws Exception;

    ArrayList<UserDTO> getAllUsers(UserFilterDTO userFilterDTO) throws IOException;
}
