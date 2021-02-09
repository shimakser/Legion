package by.shimakser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String welcomePage(Model model) {
        return "welcome";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        return "main";
    }
}
