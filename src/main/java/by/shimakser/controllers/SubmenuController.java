package by.shimakser.controllers;

import by.shimakser.model.User;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class SubmenuController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main/settings")
    public String settingsPage(Principal user, Model model) {
        model.addAttribute("login", user.getName());
        return "settings";
    }


    @GetMapping("/main/profile")
    public String profilePage(Model model, Principal user) {
        model.addAttribute("login", user.getName());
        return "profile";
    }

    @PostMapping("/main/profile")
    public String rename(Model model, Principal user, @RequestParam String username) {
        User newUser = userRepository.findByUsername(user.getName());
        newUser.setUsername(username);
        userRepository.save(newUser);
        model.addAttribute("login", newUser.getUsername());
        return "redirect:/main";
    }
}
