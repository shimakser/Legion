package by.shimakser.controller;

import by.shimakser.model.post.Category;
import by.shimakser.model.post.Post;
import by.shimakser.model.user.Role;
import by.shimakser.repo.PostRepository;
import by.shimakser.repo.UserRepository;
import by.shimakser.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class BlogController {

    private PostRepository postRepository;

    @Autowired
    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @ModelAttribute("login")
    public String activeUser(Principal user) {
        return user.getName();
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        Iterable<Post> posts = postRepository.findAllByOrderByIdDesc();
        model.addAttribute("posts", posts);
        Post mostViewsPost = postRepository.findTopByOrderByViewsDesc();
        model.addAttribute("mvp", mostViewsPost);
        Post lastPost = postRepository.findTopByOrderByIdDesc();
        model.addAttribute("lp", lastPost);
        return "main";
    }

    @PostMapping("/main")
    public String searchByTitle(@RequestParam String title, Model model) {
        Iterable<Post> posts = postRepository.findAllByTitle(title);
        model.addAttribute("posts", posts);
        model.addAttribute("titles", title);
        return "sort";
    }

    @PostMapping("/main/{id}/delete")
    public String postDelete(@PathVariable(value = "id") long id) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/main";
    }

    @GetMapping("/main/posts/{category}")
    public String sortByCategory(@PathVariable(value = "category") String category, Model model) {
        Iterable<Post> posts = postRepository.findAllByCategory(Category.valueOf(category));
        model.addAttribute("posts", posts);
        model.addAttribute("titles", category);
        return "sort";
    }
}
