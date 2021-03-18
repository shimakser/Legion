package by.shimakser.controllers;

import by.shimakser.model.User;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SubmenuController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main/settings")
    public String settingsPage(Model model) {
        return "settings";
    }

    @GetMapping("/main/{id}/profile")
    public String profilePage(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/main";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "profile";
    }

    @PostMapping("/main/{id}/profile")
    public String updateProfile(@PathVariable(value = "id") long id, @RequestParam String username, Model model) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);
        userRepository.save(user);
        return "redirect:/main";
    }
}
