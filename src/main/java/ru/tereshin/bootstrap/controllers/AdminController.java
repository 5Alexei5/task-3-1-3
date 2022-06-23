package ru.tereshin.bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tereshin.bootstrap.models.User;
import ru.tereshin.bootstrap.services.RoleService;
import ru.tereshin.bootstrap.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(RoleService roleService, UserService userService) {

        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model, Principal principal) {
        User user = userService.getUser(principal.getName());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        model.addAttribute("newUser", new User());
        model.addAttribute("roleFromDb", roleService.getRoles());

        return "admin-page";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newUser") User user, @RequestParam(value = "roleSelect") String[] roles) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles(roleService.getListRoles(roles));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
    @PostMapping("/edit/{id}")
    public String patchUser(@ModelAttribute("newUser") User user, @PathVariable("id") long id,
                            @RequestParam(value = "rolesFromModalEdit") String[] roles) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles(roleService.getListRoles(roles));
        userService.update(user, id);
        return "redirect:/admin";
    }
}
