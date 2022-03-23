package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.User;

import java.util.List;

public interface UserDao {

    List <User> getUser();

    void saveUser(User theUser);

    User getUser(int theId);

    User getUserByUsername(String username);

    void deleteUser(int theId);

    boolean validateUser (String username, String password);

}