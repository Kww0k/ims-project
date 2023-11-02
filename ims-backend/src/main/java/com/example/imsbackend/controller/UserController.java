package com.example.imsbackend.controller;

import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
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
    public List<AuthUserInfoVO> listUser() {
        return userService.listUser();
    }

    @GetMapping("/getUserById/{id}")
    public AuthUserInfoVO getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/insertUser")
    public Boolean insertUser(@RequestBody InsertUserDTO insertUserDTO) {
        return userService.insertUser(insertUserDTO);
    }

    @PostMapping("/updateUserById")
    public Boolean updateUserById(@RequestBody UpdateUserDTO updateUserDTO) {
        return userService.updateUserById(updateUserDTO);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public Boolean deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }
}
