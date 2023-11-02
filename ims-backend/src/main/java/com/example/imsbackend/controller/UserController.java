package com.example.imsbackend.controller;

import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return userService.list();
    }
}
