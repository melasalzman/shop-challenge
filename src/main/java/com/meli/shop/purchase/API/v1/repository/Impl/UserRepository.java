package com.meli.shop.purchase.API.v1.repository.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.API.v1.exception.article.AlreadyExistException;
import com.meli.shop.purchase.API.v1.repository.IUserRepository;
import com.meli.shop.purchase.API.v1.DTO.user.AddressDTO;
import com.meli.shop.purchase.API.v1.DTO.user.UserDTO;
import com.meli.shop.purchase.API.v1.DTO.user.AllUserDTO;
import com.meli.shop.purchase.API.v1.model.Address;
import com.meli.shop.purchase.API.v1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Repository
public class UserRepository implements IUserRepository {
    @Autowired
    private IDatabase iDatabase;

    @Override
    public void saveUser(UserDTO userDTO) throws Exception {
        if(findUserByName(userDTO.getName())!=null) throw new AlreadyExistException();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<UserDTO> users = new ArrayList<>();
        for (UserDTO user : getAllUsers()) {
            users.add(user);
        }
        users.add(userDTO);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        Files.write(new File("src/main/resources/users.json").toPath(), Arrays.asList(json));

    }

    @Override
    public UserDTO findUserByName(String name) throws IOException {
        return getAllUsers().stream()
                .filter(user -> user.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT)))
                .findAny()
                .orElse(null);
        }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws IOException {
        return getUserDTOList(iDatabase.loadDatabase("src/main/resources/users.json", User.class));
    }

    private ArrayList<UserDTO> getUserDTOList(ArrayList<User> users) {
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(getUserDTO(user));
        }
        return usersDTO;
    }

    private UserDTO getUserDTO(User user) {
        return new UserDTO(
                user.getId(),
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
