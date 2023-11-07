package com.example.imsbackend.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private String delFlag;

}
