package com.example.imsbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.imsbackend.domain.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserRole)表数据库访问层
 *
 * @author Silvery
 * @since 2023-11-16 01:51:18
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
