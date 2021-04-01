package by.shimakser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcomePage(Principal user, Model model) {
        if (user == null) {
            model.addAttribute("login", "Войти");
        } else model.addAttribute("login", user.getName());
        return "welcome";
    }

}
