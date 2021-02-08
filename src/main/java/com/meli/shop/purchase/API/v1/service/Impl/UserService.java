package com.meli.shop.purchase.API.v1.service.Impl;

import com.meli.shop.purchase.API.v1.repository.IUserRepository;
import com.meli.shop.purchase.API.v1.service.IUserService;
import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserFilterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void createUser(UserDTO userDTO) throws Exception {
        iUserRepository.saveUser(userDTO);
    }

    @Override
    public ArrayList<UserDTO> getAllUsers(UserFilterDTO userFilterDTO) throws IOException {
        return filterUsersByProvince(iUserRepository.getAllUsers(), userFilterDTO.getProvince());
    }

    private ArrayList<UserDTO> filterUsersByProvince(ArrayList<UserDTO> users, String province) {
        if (province != null) {
            users = (ArrayList<UserDTO>) users.stream()
                    .filter(user ->
                            user.getAddress().getProvince()
                                    .toLowerCase(Locale.ROOT)
                                    .equals(province.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
        }
        return users;
    }
}
