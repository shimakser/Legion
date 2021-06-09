package by.shimakser.controller;

import by.shimakser.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/main/{id}/edit")
public class EditController {

    private PostService postService;

    @Autowired
    public EditController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute("login")
    public String activeUser(Principal user) {
        return user.getName();
    }

    @GetMapping
    public String postEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postService.edit(id, model)) {
            return "redirect:/main";
        }
        return "edit";
    }

    @PostMapping
    public String postUpdate(@PathVariable(value = "id") long id, @RequestParam String title,
                             @RequestParam String anons, @RequestParam String mainText) {
        postService.update(id, title, anons, mainText);
        return "redirect:/main/{id}";
    }
}
