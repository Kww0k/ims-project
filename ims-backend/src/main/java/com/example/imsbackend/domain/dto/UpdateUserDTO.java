package com.example.imsbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/2 19:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
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
}
