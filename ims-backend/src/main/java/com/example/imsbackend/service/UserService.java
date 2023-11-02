package com.example.imsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author Silvery
 * @since 2023-11-02 18:44:46
 */
public interface UserService extends IService<User> {

    List<AuthUserInfoVO> listUser();

    AuthUserInfoVO getUserById(Integer id);

    Boolean insertUser(InsertUserDTO insertUserDTO);

    Boolean updateUserById(UpdateUserDTO updateUserDTO);

    Boolean deleteUserById(Integer id);
}
