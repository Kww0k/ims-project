package com.example.imsbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Silvery
 * @since 2023/11/1 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {

    private String username;

    private String password;
}
