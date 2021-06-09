package by.shimakser.service;

import by.shimakser.model.post.Post;
import by.shimakser.model.user.Role;
import by.shimakser.repo.PostRepository;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public boolean displayFullPost(long id, Principal user, Model model) {
        if (!postRepository.existsById(id)) {
            return false;
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

        model.addAttribute("login", user.getName());
        model.addAttribute("post", res);
        model.addAttribute("title", post2.getTitle());
        return true;
    }

    public boolean edit(long id, Model model) {
        if (!postRepository.existsById(id)) {
            return false;
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return true;
    }

    public void update(long id, String title, String anons, String mainText) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setMainText(mainText);
        postRepository.save(post);
    }
}
