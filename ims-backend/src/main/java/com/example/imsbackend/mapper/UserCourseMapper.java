package com.example.imsbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.imsbackend.domain.entity.UserCourse;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserCourse)表数据库访问层
 *
 * @author Silvery
 * @since 2023-11-15 01:41:39
 */
@Mapper
public interface UserCourseMapper extends BaseMapper<UserCourse> {

}
