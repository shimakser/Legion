package by.shimakser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String welcomePage(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String mainPage(Model model) {
        return "register";
    }
}
