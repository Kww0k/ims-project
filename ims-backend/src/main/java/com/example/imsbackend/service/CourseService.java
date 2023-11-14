package com.example.imsbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.imsbackend.domain.entity.Course;
import com.example.imsbackend.domain.vo.CoursePage;
import com.example.imsbackend.domain.vo.CourseVO;

import java.util.List;


/**
 * (Course)表服务接口
 *
 * @author Silvery
 * @since 2023-11-15 01:39:20
 */
public interface CourseService extends IService<Course> {

    CoursePage listCourse(Integer pageNum, Integer pageSize, String name);
}
