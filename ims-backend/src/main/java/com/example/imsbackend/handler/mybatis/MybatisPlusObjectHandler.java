package com.example.imsbackend.handler.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.imsbackend.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/7 17:17
 */
@Component
@RequiredArgsConstructor
public class MybatisPlusObjectHandler implements MetaObjectHandler {

    private final SecurityUtil securityUtil;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", securityUtil.getUserId() , metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", securityUtil.getUserId(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", securityUtil.getUserId(), metaObject);
    }
}
