package by.shimakser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping("/register")
    public String registration(Model model) {
        return "register";
    }
}
