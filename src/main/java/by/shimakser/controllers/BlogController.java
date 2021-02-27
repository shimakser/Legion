package by.shimakser.controllers;

import by.shimakser.models.Post;
import by.shimakser.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/main")
    public String mainPage(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "main";
    }

    @GetMapping("/main/adding")
    public String addingPage(Model model) {
        return "adding";
    }

    @PostMapping("/main/adding")
    public String postAdd(@RequestParam String name, @RequestParam String anons, @RequestParam String fullText, Model model) {
        Post post = new Post(name, anons, fullText);
        postRepository.save(post);
        return "redirect:/main";
    }
}
