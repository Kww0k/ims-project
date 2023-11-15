package com.example.imsbackend.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (UserRole)表实体类
 *
 * @author Silvery
 * @since 2023-11-16 01:51:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user_role")
public class UserRole  {

    private Integer userId;
    private Integer roleId;



}
