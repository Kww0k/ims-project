package com.example.imsbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.imsbackend.domain.entity.Course;
import com.example.imsbackend.domain.vo.CoursePage;
import com.example.imsbackend.domain.vo.CourseVO;
import com.example.imsbackend.mapper.CourseMapper;
import com.example.imsbackend.mapper.UserMapper;
import com.example.imsbackend.service.CourseService;
import com.example.imsbackend.utils.BeanCopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author Silvery
 * @since 2023-11-15 01:39:20
 */
@Service("courseService")
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    private final BeanCopyUtils beanCopyUtils;

    private final UserMapper userMapper;

    @Override
    public CoursePage listCourse(Integer pageNum, Integer pageSize, String name) {
        Page<Course> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(name), Course::getName, name);
        page(page, wrapper);
        List<Course> courseList = page.getRecords();
        List<CourseVO> courseVOS = courseList.stream()
                .map(course -> {
                    CourseVO courseVO = beanCopyUtils.copyBean(course, CourseVO.class);
                    courseVO.setOpenedBy(userMapper.selectById(course.getOpenedBy()).getUsername());
                    return courseVO;
                })
                .toList();
        return new CoursePage(courseVOS, page.getTotal());
    }
}
