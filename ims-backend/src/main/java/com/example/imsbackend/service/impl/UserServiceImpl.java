package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.service.UserService;
import com.example.imsbackend.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-02 18:44:48
 */
@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final BeanCopyUtils beanCopyUtils;

    @Override
    public List<AuthUserInfoVO> listUser() {
        return baseMapper.selectList(null)
                .stream()
                .map(user -> beanCopyUtils.copyBean(user, AuthUserInfoVO.class))
                .toList();
    }

    @Override
    public AuthUserInfoVO getUserById(Integer id) {
        return beanCopyUtils.copyBean(baseMapper.selectById(id), AuthUserInfoVO.class);
    }

    @Override
    public Boolean insertUser(InsertUserDTO insertUserDTO) {
        User user = beanCopyUtils.copyBean(insertUserDTO, User.class);
        return baseMapper.insert(user) == 1;
    }

    @Override
    public Boolean updateUserById(UpdateUserDTO updateUserDTO) {
        User user = beanCopyUtils.copyBean(updateUserDTO, User.class);
        return baseMapper.updateById(user) == 1;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return baseMapper.deleteById(id) == 1;
    }
}
