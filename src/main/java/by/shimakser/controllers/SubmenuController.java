package by.shimakser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmenuController {

    @GetMapping("/settings")
    public String settingsPage(Model model) {
        return "settings";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        return "profile";
    }
}
