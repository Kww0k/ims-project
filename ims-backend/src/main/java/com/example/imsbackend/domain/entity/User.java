package com.example.imsbackend.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/10/31 16:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class User  {
    @TableId
    private Integer id;

    private String username;
    private String password;
    private String address;
    private String code;
    private String identificationCard;
    private Date birthday;
    private String sex;
    private Date enterTime;
    private Date finishTime;
    private Date createTime;
    private Integer createBy;
    private Date updateTime;
    private Integer updateBy;
    private String delFlag;



}
