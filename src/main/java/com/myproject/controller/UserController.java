package com.myproject.controller;

import com.myproject.domain.User;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public User getUserByID(@PathVariable("id") int id) {
        return userService.getUserByID(id);
    }
}
