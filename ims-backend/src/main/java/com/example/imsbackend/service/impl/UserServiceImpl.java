package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.LoginUser;
import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.entity.UserRole;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import com.example.imsbackend.handler.exception.DeleteStudentException;
import com.example.imsbackend.handler.exception.InsertStudentException;
import com.example.imsbackend.handler.exception.UsernamePasswordException;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.mapper.UserRoleMapper;
import com.example.imsbackend.service.UserService;
import com.example.imsbackend.utils.BeanCopyUtils;
import com.example.imsbackend.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

import static com.example.imsbackend.constants.OtherConstants.STUDENT_ID;

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

    private final SecurityUtil securityUtil;

    private final UserRoleMapper userRoleMapper;

    @Override
    public List<AuthUserInfoVO> listUser(String username, String address) {
        LambdaQueryWrapper<User> like = new LambdaQueryWrapper<User>()
                .like(StringUtils.hasText(username), User::getUsername, username)
                .like(StringUtils.hasText(address), User::getAddress, address);
        return baseMapper.selectList(like)
                .stream()
                .filter(user -> !Objects.equals(user.getId(), securityUtil.getUserId()))
                .filter(user -> {
                    LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    userRoleLambdaQueryWrapper.eq(UserRole::getUserId, user.getId());
                    UserRole userRole = userRoleMapper.selectOne(userRoleLambdaQueryWrapper);
                    if (userRole == null)
                        return false;
                    return Objects.equals(userRole.getRoleId(), STUDENT_ID);
                })
                .map(user -> beanCopyUtils.copyBean(user, AuthUserInfoVO.class))
                .toList();
    }

    @Override
    public AuthUserInfoVO getUserById(Integer id) {
        return beanCopyUtils.copyBean(baseMapper.selectById(id), AuthUserInfoVO.class);
    }

    @Override
    @Transactional
    public Boolean insertUser(InsertUserDTO insertUserDTO) {
        User user = beanCopyUtils.copyBean(insertUserDTO, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        if (baseMapper.insert(user) == 0)
            throw new InsertStudentException();
        if (userRoleMapper.insert(new UserRole(user.getId(), STUDENT_ID)) == 0)
            throw new InsertStudentException();
        return true;
    }

    @Override
    public Boolean updateUserById(UpdateUserDTO updateUserDTO) {
        User user = beanCopyUtils.copyBean(updateUserDTO, User.class);
        return baseMapper.updateById(user) == 1;
    }

    @Override
    @Transactional
    public Boolean deleteUserById(Integer id) {
        if (baseMapper.deleteById(id) == 0)
            throw new DeleteStudentException();
        if (userRoleMapper.delete(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, id)) == 0)
            throw new DeleteStudentException();
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .or()
                .eq(User::getCode, username));
        if (user == null)
            throw new UsernamePasswordException();
        return new LoginUser(user);
    }
}
