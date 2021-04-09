package by.shimakser.controller;

import by.shimakser.model.post.Category;
import by.shimakser.model.post.Post;
import by.shimakser.model.user.Role;
import by.shimakser.repo.PostRepository;
import by.shimakser.repo.UserRepository;
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

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/main/add")
    public String addingPage(Model model) {
        return "add";
    }

    @PostMapping("/main/add")
    public String postAdd(Principal user, @RequestParam String category, @RequestParam String title,
                          @RequestParam String anons, @RequestParam String mainText, Model model) {
        Post post = new Post(title, anons, mainText, user.getName());
        post.setCategory(Category.valueOf(category));
        postRepository.save(post);
        return "redirect:/main";
    }

    @GetMapping("/main/{id}")
    public String fullPost(@PathVariable(value = "id") long id, Principal user, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/main";
        }
        Post post2 = postRepository.findById(id).orElseThrow();
        post2.setViews(post2.getViews() + 1);
        postRepository.save(post2);
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);

        // Проверка активного пользователя на наличие роли Админа или имени автора
        // для активации кнопок редактирования и удаления на странцие
        Set<Role> roleSet = userRepository.findByUsername(user.getName()).getRoles();
        boolean checkRole = roleSet.contains(Role.ADMIN);
        boolean checkName = post2.getAuthor().equals(user.getName());
        if (checkRole || checkName) model.addAttribute("class", "");
            else model.addAttribute("class", "blok");
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
