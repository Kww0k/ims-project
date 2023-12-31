package com.example.imsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


/**
 * (User)表服务接口
 *
 * @author Silvery
 * @since 2023-11-02 18:44:46
 */
public interface UserService extends IService<User>, UserDetailsService {

    List<AuthUserInfoVO> listUser(String username, String address);

    AuthUserInfoVO getUserById(Integer id);

    Boolean insertUser(InsertUserDTO insertUserDTO);

    Boolean updateUserById(UpdateUserDTO updateUserDTO);

    Boolean deleteUserById(Integer id);
}
