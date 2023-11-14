package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.entity.UserCourse;
import com.example.imsbackend.mapper.UserCourseMapper;
import com.example.imsbackend.service.UserCourseService;
import org.springframework.stereotype.Service;

/**
 * (UserCourse)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-15 01:41:40
 */
@Service("userCourseService")
public class UserCourseServiceImpl extends ServiceImpl<UserCourseMapper, UserCourse> implements UserCourseService {

}
