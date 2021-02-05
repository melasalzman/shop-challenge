package com.meli.shop.purchase.API.v1.repository.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.API.v1.repository.IUserRepository;
import com.meli.shop.purchase.API.v1.DTO.user.AddressDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;
import com.meli.shop.purchase.API.v1.Model.Address;
import com.meli.shop.purchase.API.v1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private IDatabase iDatabase;

    @Override
    public void saveUser(UserDTO userDTO) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDTO);
        Files.write(new File("src/main/resources/users.json").toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
    }

    @Override
    public AllUserDTO getAllUsers() throws IOException {
        return getUserDTOList(iDatabase.loadDatabase("src/main/resources/users.json", User.class));
    }

    private AllUserDTO getUserDTOList(ArrayList<User> users) {
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(getUserDTO(user));
        }
        return new AllUserDTO(usersDTO);
    }

    private UserDTO getUserDTO(User user) {
        return new UserDTO(
                user.getName(),
                user.getSurname(),
                user.getBirthdate(),
                user.getUserName(),
                getAddressDTO(user.getAddress()),
                user.getPhoneNumber()
        );
    }

    private AddressDTO getAddressDTO(Address address) {
        return new AddressDTO(
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getProvince(),
                address.getCountry(),
                address.getPostalCode());
    }
}
