package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-02 18:44:48
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
