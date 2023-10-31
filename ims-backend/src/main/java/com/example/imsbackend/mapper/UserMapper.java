package com.example.imsbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.imsbackend.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Silvery
 * @since 2023/10/31 16:57
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
