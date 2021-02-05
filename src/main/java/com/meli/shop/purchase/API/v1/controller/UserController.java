package com.meli.shop.purchase.API.v1.controller;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;
import com.meli.shop.purchase.API.v1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping("/api/v1/user/create")
    public void createUser(@RequestBody UserDTO userDTO) throws Exception {
        iUserService.createUser(userDTO);
    }

    @GetMapping("/api/v1/user")
    public AllUserDTO getAllUsers(UserFilterDTO userFilterDTO) throws Exception {
        return iUserService.getAllUsers(userFilterDTO);
    }

}
