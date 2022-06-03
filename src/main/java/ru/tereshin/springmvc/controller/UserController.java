package ru.tereshin.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tereshin.springmvc.model.User;
import ru.tereshin.springmvc.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "/users";
    }

    @GetMapping ("/new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "/update";
    }

    @PatchMapping("/users/{id}")
    public String patchUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
