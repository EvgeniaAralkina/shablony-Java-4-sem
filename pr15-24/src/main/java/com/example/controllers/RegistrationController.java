package com.example.controllers;

import com.example.Role;
import com.example.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";
    }
}
