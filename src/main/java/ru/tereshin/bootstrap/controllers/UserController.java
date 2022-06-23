package ru.tereshin.bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tereshin.bootstrap.services.UserService;


import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String user(Model model, Principal principal) {
        model.addAttribute("user", userService.getUser(principal.getName()));
        return "user";
    }
}
