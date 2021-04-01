package by.shimakser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ChatController {

    @GetMapping("/main/chat")
    public String welcomePage(Principal user, Model model) {
        model.addAttribute("login", user.getName());
        return "chat";
    }
}
