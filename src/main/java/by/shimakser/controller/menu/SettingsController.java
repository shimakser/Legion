package by.shimakser.controller.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class SettingsController {

    @ModelAttribute("login")
    public String activeUser(Principal user) {
        return user.getName();
    }

    @GetMapping("/main/settings")
    public String settingsPage() {
        return "settings";
    }
}
