package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-02 18:44:48
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> listUser() {
        return baseMapper.selectList(null);
    }

    @Override
    public User getUserById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Boolean insertUser(User user) {
        return baseMapper.insert(user) == 1;
    }

    @Override
    public Boolean updateUserById(User user) {
        return baseMapper.updateById(user) == 1;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return baseMapper.deleteById(id) == 1;
    }
}
