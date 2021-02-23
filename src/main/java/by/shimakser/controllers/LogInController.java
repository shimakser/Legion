package by.shimakser.controllers;

import by.shimakser.models.Role;
import by.shimakser.models.User;
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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login")
    public String login(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb == null) {
            return "register";
        } else {
            return "main";
        }
    }

    @GetMapping("/register")
    public String registration() {
        return "register";
    }

    @PostMapping("/registr")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return "register";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "main";
    }
}
