package com.example.imsbackend.domain.vo;

import com.example.imsbackend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Silvery
 * @since 2023/11/7 15:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthVO {

    private AuthUserInfoVO authUserInfoVO;

    private String token;
}
