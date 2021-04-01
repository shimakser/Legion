package by.shimakser.controller;

import by.shimakser.model.post.Category;
import by.shimakser.model.post.Post;
import by.shimakser.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/main")
    public String mainPage(Principal user, Model model) {
        model.addAttribute("login", user.getName());
        Iterable<Post> posts = postRepository.findAllByOrderByIdDesc();
        model.addAttribute("posts", posts);
        Post mostViewsPost = postRepository.findTopByOrderByViewsDesc();
        model.addAttribute("mvp", mostViewsPost);
        Post lastPost = postRepository.findTopByOrderByIdDesc();
        model.addAttribute("lp", lastPost);
        return "main";
    }

    @PostMapping("/main")
    public String searchByTitle(@RequestParam String title, Principal user, Model model) {
        Iterable<Post> posts = postRepository.findAllByTitle(title);
        model.addAttribute("posts", posts);
        model.addAttribute("titles", title);
        model.addAttribute("login", user.getName());
        return "sort";
    }

    @GetMapping("/main/add")
    public String addingPage(Principal user, Model model) {
        model.addAttribute("login", user.getName());
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
    public String fullPost(@PathVariable(value = "id") long id, Principal user, Model model) {
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
        model.addAttribute("login", user.getName());
        return "post";
    }

    @PostMapping("/main/{id}/delete")
    public String postDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}/edit")
    public String postEdit(@PathVariable(value = "id") long id, Principal user, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/main";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("login", user.getName());
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
    public String sortByCategory(@PathVariable(value = "category") String category, Principal user, Model model) {
        Iterable<Post> posts = postRepository.findAllByCategory(Category.valueOf(category));
        model.addAttribute("posts", posts);
        model.addAttribute("titles", category);
        model.addAttribute("login", user.getName());
        return "sort";
    }
}
