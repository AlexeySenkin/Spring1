package ru.senkin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.senkin.repsist.User;
import ru.senkin.repsist.InMemoryUserRepository;
import ru.senkin.repsist.UserRepository;
import ru.senkin.repsist.UserRepositoryImpl;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserRepositoryImpl userRepository;

//    public UserController(UserRepositoryImpl userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.userById(id));
        return "user_form";
    }

    @GetMapping("/new_user")
    public String addUser(Model model) {
        model.addAttribute("user", new User(""));
        return "user_form";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/user";
    }

    @PostMapping
    public String editUser(User user) {
        userRepository.save(user);
        return "redirect:/user";
    }




}
