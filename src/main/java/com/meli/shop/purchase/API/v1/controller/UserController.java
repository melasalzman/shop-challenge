package com.meli.shop.purchase.API.v1.controller;

import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;
import com.meli.shop.purchase.API.v1.service.IPurchaseService;
import com.meli.shop.purchase.API.v1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/user/create")
    public void createUser(@RequestBody UserDTO userDTO) throws Exception {
        iUserService.createUser(userDTO);
    }

    @GetMapping("/user")
    public AllUserDTO getAllUsers(UserFilterDTO userFilterDTO) throws Exception {
        return new AllUserDTO(iUserService.getAllUsers(userFilterDTO));
    }

}
