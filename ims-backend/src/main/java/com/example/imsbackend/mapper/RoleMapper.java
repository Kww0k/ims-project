package com.example.imsbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.imsbackend.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Role)表数据库访问层
 *
 * @author Silvery
 * @since 2023-11-16 01:51:17
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
