package com.example.imsbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/1 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserInfoVO {

    private Integer id;

    private String username;
    private String address;
    private String code;
    private String identificationCard;
    private Date birthday;
    private String sex;
    private Date enterTime;
    private Date finishTime;
}
