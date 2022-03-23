package net.progetto.springmvc.service;

import net.progetto.springmvc.dto.UserDto;
import net.progetto.springmvc.entity.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    List <User> getUser();

    void saveUser(UserDto theUser) throws ParseException;

    User getUser(int theId);

    User getUserByUsername(String username);

    void deleteUser(int theId);


}