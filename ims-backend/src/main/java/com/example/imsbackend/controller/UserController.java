package com.example.imsbackend.controller;

import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Silvery
 * @since 2023/11/2 18:46
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/listUser")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/insertUser")
    public Boolean insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/updateUserById")
    public Boolean updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public Boolean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}