package com.example.imsbackend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author Silvery
 * @since 2023/11/2 19:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    @Length(min = 3, max = 30, message = "用户名的长度必须在3-30")
    private String username;
    @NotBlank(message = "地址不能为空")
    private String address;
    @NotBlank(message = "身份码不能为空")
    private String code;
    @Length(max = 18, min = 18, message = "身份证必须是18位")
//    @Pattern(regexp = "^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}(\\d|X|x)$", message = "身份证格式错误")
    private String identificationCard;
    @NotBlank(message = "生日不能为空")
    private Date birthday;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "入学时间不能为空")
    private Date enterTime;
    @NotBlank(message = "离开时间不能为空")
    private Date finishTime;
}
