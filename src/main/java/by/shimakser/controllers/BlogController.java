package by.shimakser.controllers;

import by.shimakser.model.Category;
import by.shimakser.model.Post;
import by.shimakser.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/main")
    public String mainPage(Model model) {
        Iterable<Post> posts = postRepository.findAllByOrderByIdDesc();
        //Iterable<Post> mvp = postRepository.findTopByViews();
        model.addAttribute("posts", posts);
        //model.addAttribute("mvp", mvp);
        return "main";
    }

    @PostMapping("/main")
    public String searchByTitle(@RequestParam String title, Model model) {
        Iterable<Post> posts = postRepository.findAllByTitle(title);
        model.addAttribute("posts", posts);
        model.addAttribute("titles", title);
        return "sort";
    }

    @GetMapping("/main/add")
    public String addingPage(Model model) {
        return "add";
    }

    @PostMapping("/main/add")
    public String postAdd(@RequestParam String category, @RequestParam String title, @RequestParam String anons, @RequestParam String mainText, Model model) {
        Post post = new Post(title, anons, mainText);
        post.setCategory(Category.valueOf(category));
        postRepository.save(post);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}")
    public String fullPost(@PathVariable(value = "id") long id, Model model) {
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
        model.addAttribute("title", post2.getTitle());
        return "post";
    }

    @PostMapping("/main/{id}/delete")
    public String postDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}/edit")
    public String postEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/main";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "edit";
    }

    @PostMapping("/main/{id}/edit")
    public String postUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String mainText, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setMainText(mainText);
        postRepository.save(post);
        return "redirect:/main/{id}";
    }

    @GetMapping("/main/posts/{category}")
    public String sortByCategory(@PathVariable(value = "category") String category, Model model) {
        Iterable<Post> posts = postRepository.findAllByCategory(Category.valueOf(category));
        model.addAttribute("posts", posts);
        model.addAttribute("titles", category);
        return "sort";
    }
}
