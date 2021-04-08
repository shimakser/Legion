package by.shimakser.controller;

import by.shimakser.model.user.User;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class SubmenuController {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("login")
    public String activeUser(Principal user) {
        return user.getName();
    }

    @GetMapping("/main/settings")
    public String settingsPage(Model model) {
        return "settings";
    }

    @GetMapping("/main/profile")
    public String profilePage(Model model) {
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
