package net.progetto.springmvc.service;

import net.progetto.springmvc.dao.UserDao;
import net.progetto.springmvc.dto.UserDto;
import net.progetto.springmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List <User> getUser() {
        return userDAO.getUser();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }

    @Override
    @Transactional
    public void saveUser(UserDto theUser) throws ParseException {
        User userEntity = new User();
        userEntity.setId(theUser.getId());
        userEntity.setFirstName(theUser.getFirstName());
        userEntity.setLastName(theUser.getLastName());

        Date dateEntity = new SimpleDateFormat("yyyy-MM-dd").parse(theUser.getDate());
        userEntity.setDate(dateEntity);

        userEntity.setUsername(theUser.getUsername());
        userEntity.setPassword(passwordEncoder.encode(theUser.getPassword()));
        userDAO.saveUser(userEntity);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userDAO.deleteUser(theId);
    }
}