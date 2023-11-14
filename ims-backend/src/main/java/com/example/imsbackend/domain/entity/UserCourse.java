package com.example.imsbackend.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (UserCourse)表实体类
 *
 * @author Silvery
 * @since 2023-11-15 01:41:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user_course")
public class UserCourse  {

    private Integer userId;
    private Integer courseId;



}
