package com.example.imsbackend.utils;

import com.example.imsbackend.domain.LoginUser;
import com.example.imsbackend.domain.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Silvery
 * @since 2023/11/7 17:14
 */
@Component
public class SecurityUtil {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public LoginUser getLoginUser() {
        if (getAuthentication().getPrincipal() != null)
            return (LoginUser) getAuthentication().getPrincipal();
        else
            return new LoginUser(new User().setId(-1));
    }

    public Integer getUserId() {
        return getLoginUser().getUser().getId();
    }
}
