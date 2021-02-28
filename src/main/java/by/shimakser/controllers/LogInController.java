package by.shimakser.controllers;

import by.shimakser.models.Role;
import by.shimakser.models.Users;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class LogInController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
