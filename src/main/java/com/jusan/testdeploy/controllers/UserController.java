package com.jusan.testdeploy.controllers;

import com.jusan.testdeploy.domains.UserEntity;
import com.jusan.testdeploy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/createUser")
    public String showCreateUserForm(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam String userName, @RequestParam String password, Model model) {
        try {
            UserEntity user = UserEntity.builder()
                    .userName(userName)
                    .password(password)
                    .build();
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "Username already exists.");
        }
        model.addAttribute("users", userRepository.findAll());
        return "createUser";
    }
}