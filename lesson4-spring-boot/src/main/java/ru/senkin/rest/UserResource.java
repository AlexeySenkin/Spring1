package ru.senkin.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.senkin.model.User;
import ru.senkin.model.dto.UserDto;
import ru.senkin.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto form(@PathVariable("id") long id, Model model) {
        return userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    @GetMapping
    public List<UserDto> listPage(
            @RequestParam(required = false) String usernameFilter,
            @RequestParam(required = false) String emailFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            Model model) {
        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(10);

        Page<UserDto> userDtoPage = userService.findAllByFilter(usernameFilter,emailFilter, pageValue, sizeValue);

        return userDtoPage.get().collect(Collectors.toList());
    }

    @PostMapping
    public UserDto editUser(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            throw new IllegalArgumentException("shouldn't have ID");
        }
        userService.save(userDto);
        return userDto;
    }

}
