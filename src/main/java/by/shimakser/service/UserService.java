package by.shimakser.service;

import by.shimakser.model.user.Role;
import by.shimakser.model.user.User;
import by.shimakser.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Collections;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return true;
    }

    public void rename(Model model, Principal user, String username) {
        User newUser = userRepository.findByUsername(user.getName());
        newUser.setUsername(username);
        userRepository.save(newUser);
        model.addAttribute("login", newUser.getUsername());
    }
}