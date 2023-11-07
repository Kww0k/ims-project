package com.example.imsbackend.config;

import com.example.imsbackend.domain.LoginUser;
import com.example.imsbackend.domain.ResultBean;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import com.example.imsbackend.domain.vo.AuthVO;
import com.example.imsbackend.filter.JwtFilter;
import com.example.imsbackend.utils.BeanCopyUtils;
import com.example.imsbackend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static com.example.imsbackend.constants.HttpStatus.HTTP_STATUS_401;
import static com.example.imsbackend.constants.OtherConstants.AUTH_TOKEN;
import static com.example.imsbackend.enums.HttpMessage.LOGOUT_ERROR;

/**
 * @author Silvery
 * @since 2023/11/7 15:26
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    private final JwtUtil jwtUtil;

    private final BeanCopyUtils beanCopyUtils;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(conf -> conf
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated())
                .formLogin(conf -> conf
                        .loginProcessingUrl("/login")
                        .successHandler((request, response, authentication) -> {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("utf-8");
                            // 获取登陆的用户信息
                            LoginUser user = (LoginUser) authentication.getPrincipal();
                            // 生成jwt
                            String token = jwtUtil.createJwt(user);
                            AuthUserInfoVO authUserInfoVO = beanCopyUtils.copyBean(user.getUser(), AuthUserInfoVO.class);
                            AuthVO authVO = new AuthVO(authUserInfoVO, token);
                            // 返回
                            response.getWriter().write(ResultBean.success(authVO).toJsonString());
                        })
                        .failureHandler((request, response, exception) -> {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("utf-8");
                            response.getWriter().write(ResultBean.failure(HTTP_STATUS_401, exception.getMessage()).toJsonString());
                        }))
                .logout(conf -> conf.logoutUrl("/logout")
                        .logoutSuccessHandler((request, response, authentication) -> {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("utf-8");
                            // 获取token
                            String authorization = request.getHeader(AUTH_TOKEN);
                            if (jwtUtil.invalidateJwt(authorization))
                                response.getWriter().write(ResultBean.success(null).toJsonString());
                            else
                                response.getWriter().write(ResultBean.failure(LOGOUT_ERROR).toJsonString());
                        }))
                .exceptionHandling(conf -> conf
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setContentType("application/json");
                            response.setCharacterEncoding("utf-8");
                            response.getWriter().write(ResultBean.failure(HTTP_STATUS_401, authException.getMessage()).toJsonString());
                        }))
                .csrf(AbstractHttpConfigurer::disable)
                .cors(conf -> conf.configurationSource(configurationSource()))
                .sessionManagement(conf -> conf.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private CorsConfigurationSource configurationSource() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedOriginPattern("*");
        cors.setAllowCredentials(true);
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        cors.addExposedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
}
