package net.progetto.springmvc.controller;

import net.progetto.springmvc.dto.UserDto;
import net.progetto.springmvc.entity.User;
import net.progetto.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String listUser(Model theModel) {
        List <User> theUsers = userService.getUser();
        theModel.addAttribute("users", theUsers);
        return "user-list";
    }


    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        UserDto theUser = new UserDto();
        theModel.addAttribute("user", theUser);
        return "user-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserDto theUser) throws ParseException {
        userService.saveUser(theUser);
        return "redirect:/user/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
        User theUser = userService.getUser(theId);
        theModel.addAttribute("user", theUser);
        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
        userService.deleteUser(theId);
        return "redirect:/user/list";
    }
}