package by.shimakser.controllers;

import by.shimakser.models.Post;
import by.shimakser.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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
    public String postAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String mainText, Model model) {
        Post post = new Post(title, anons, mainText);
        postRepository.save(post);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/main";
        }
        //views + 1
        Post post2 = postRepository.findById(id).orElseThrow();
        post2.setViews(post2.getViews() + 1);
        postRepository.save(post2);
        //page
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "post";
    }
}
