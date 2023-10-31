package com.example.imsbackend.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Silvery
 * @since 2023/10/31 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId
    Integer id;

    String username;

    String password;
}
