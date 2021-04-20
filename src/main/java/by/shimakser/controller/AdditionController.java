package by.shimakser.controller;

import by.shimakser.model.post.Category;
import by.shimakser.model.post.Post;
import by.shimakser.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/main/add")
public class AdditionController {

    @Autowired
    private PostRepository postRepository;

    @ModelAttribute("login")
    public String activeUser(Principal user) {
        return user.getName();
    }

    @GetMapping
    public String addingPage() {
        return "add";
    }

    @PostMapping
    public String postAdd(Principal user, @RequestParam String category, @RequestParam String title,
                          @RequestParam String anons, @RequestParam String mainText) {
        Post post = new Post(title, anons, mainText, user.getName());
        post.setCategory(Category.valueOf(category));
        postRepository.save(post);
        return "redirect:/main";
    }
}
