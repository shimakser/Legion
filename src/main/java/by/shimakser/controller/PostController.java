package by.shimakser.controller;

import by.shimakser.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/main/{id}")
    public String fullPost(@PathVariable(value = "id") long id, Principal user, Model model) {
        if (!postService.displayFullPost(id, user, model)) {
            return "redirect:/main";
        }
        return "post";
    }
}
