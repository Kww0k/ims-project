package com.example.imsbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.handler.exception.UsernamePasswordException;
import com.example.imsbackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author Silvery
 * @since 2023/10/31 15:15
 */
@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserMapper userMapper;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User dbUser = userMapper.selectOne(wrapper);
        if (dbUser == null || !Objects.equals(dbUser.getPassword(), user.getPassword()))
            throw new UsernamePasswordException();
        return dbUser;
    }
}
