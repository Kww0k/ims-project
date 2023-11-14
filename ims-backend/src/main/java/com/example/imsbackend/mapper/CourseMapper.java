package com.example.imsbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.imsbackend.domain.entity.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Course)表数据库访问层
 *
 * @author Silvery
 * @since 2023-11-15 01:39:19
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}
