package com.example.imsbackend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/2 19:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserDTO {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 30, message = "用户名的长度必须在3-30")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码必须在6-18位")
    private String password;

    private String address;

    private String code;
    @Length(max = 18, min = 18, message = "身份证必须是18位")
//    @Pattern(regexp = "^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}(\\d|X|x)$", message = "身份证格式错误")
    private String identificationCard;

    private Date birthday;

    private String sex;

    private Date enterTime;

    private Date finishTime;
}
