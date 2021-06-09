package by.shimakser.controller.menu;

import by.shimakser.model.user.User;
import by.shimakser.repo.UserRepository;
import by.shimakser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProfileController {

    private UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main/profile")
    public String profilePage(Principal user, Model model) {
        model.addAttribute("login", user.getName());
        return "profile";
    }

    @PostMapping("/main/profile")
    public String renameUser(Model model, Principal user, @RequestParam String username) {
        userService.rename(model, user, username);
        return "redirect:/main";
    }
}
