package com.example.imsbackend.controller;

import com.example.imsbackend.domain.vo.CoursePage;
import com.example.imsbackend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silvery
 * @since 2023/11/15 02:21
 */
@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/listCourse")
    public CoursePage listCourse(Integer pageNum, Integer pageSize, String name) {
        return courseService.listCourse(pageNum, pageSize, name);
    }

}
