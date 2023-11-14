package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.entity.Course;
import com.example.imsbackend.mapper.CourseMapper;
import com.example.imsbackend.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * (Course)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-15 01:39:20
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
