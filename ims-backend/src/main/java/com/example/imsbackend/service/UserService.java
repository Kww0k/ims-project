package com.example.imsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.imsbackend.domain.entity.User;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author Silvery
 * @since 2023-11-02 18:44:46
 */
public interface UserService extends IService<User> {

    List<User> listUser();

    User getUserById(Integer id);

    Boolean insertUser(User user);

    Boolean updateUserById(User user);

    Boolean deleteUserById(Integer id);
}
