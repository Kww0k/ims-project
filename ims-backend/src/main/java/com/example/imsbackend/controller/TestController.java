package com.example.imsbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.LoginVO;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import com.example.imsbackend.handler.exception.UsernamePasswordException;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.mapper.struct.BeanCopyUtil;
import lombok.RequiredArgsConstructor;
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
    public AuthUserInfoVO login(@RequestBody LoginVO loginVO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, loginVO.getUsername());
        User dbUser = userMapper.selectOne(wrapper);
        if (dbUser == null || !Objects.equals(dbUser.getPassword(), loginVO.getPassword()))
            throw new UsernamePasswordException();
        return BeanCopyUtil.INSTANCE.toAuthUserInfo(dbUser);
    }
}
