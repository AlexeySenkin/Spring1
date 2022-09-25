package ru.senkin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.senkin.model.dto.UserDto;
import ru.senkin.service.UserService;
import java.util.Optional;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String listPage(
            @RequestParam(required = false) String usernameFilter,
            @RequestParam(required = false) String emailFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            Model model) {

//        QUser user = QUser.user;
//        BooleanBuilder predicate = new BooleanBuilder();
//        if (usernameFilter != null && !usernameFilter.isBlank()) {
//            predicate.and(user.username.contains(usernameFilter.trim()));
//        }
//        if (emailFilter != null && !emailFilter.isBlank()) {
//            predicate.and(user.username.contains(emailFilter.trim()));
//        }

        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(10);

        model.addAttribute("users", userService.findAllByFilter(usernameFilter,emailFilter, pageValue, sizeValue));

        return "user";
    }


    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user_form";
    }

    @GetMapping("/new_user")
    public String addUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "user_form";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/user";
    }

    @PostMapping
    public String editUser(@ModelAttribute("user") UserDto userDto) {
        userService.save(userDto);
        return "redirect:/user";
    }




}
