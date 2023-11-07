package com.example.imsbackend.utils;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.imsbackend.domain.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.example.imsbackend.constants.OtherConstants.JWT_BLACK_LIST;
import static com.example.imsbackend.constants.OtherConstants.TOKEN_SITE;

/**
 * @author Silvery
 * @since 2023/11/7 15:34
 */
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private static final String key = "ims_test";

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * jwt失效
     *
     * @param headerToken 头标记
     * @return boolean
     */
    public boolean invalidateJwt(String headerToken) {
        String token = convertToken(headerToken);
        if (token == null) return false;
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);
            String id = verify.getId();
            return deleteToken(id, verify.getExpiresAt());
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    private boolean deleteToken(String uuid, Date time) {
        if (isInvalidToken(uuid)) return false;
        Date now = new Date();
        long expire = Math.max(time.getTime() - now.getTime(), 0);
        stringRedisTemplate.opsForValue().set(JWT_BLACK_LIST + uuid, "", expire, TimeUnit.MILLISECONDS);
        return true;
    }

    private boolean isInvalidToken(String uuid) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(JWT_BLACK_LIST + uuid));
    }


    /**
     * 创建jwt
     *
     * @author Silvery
     * @since 2023/8/18 14:42
     * @param details 用户登陆信息
     * @return String
     */
    public String createJwt(LoginUser details) {
        Algorithm algorithm = Algorithm.HMAC256(key);
        return JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("user", JSONObject.toJSONString(details, JSONWriter.Feature.WriteNulls))
                .withExpiresAt(expireTime())
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    /**
     * 解析token
     *
     * @author Silvery
     * @since 2023/8/18 14:42
     * @param authToken token
     * @return DecodedJWT
     */
    public DecodedJWT resolveJwt(String authToken) {
        String token = convertToken(authToken);
        if (token == null)
            return null;
        Algorithm algorithm = Algorithm.HMAC256(key);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);
            if (isInvalidToken(verify.getId()))
                return null;
            Date expiresAt = verify.getExpiresAt();
            return new Date().after(expiresAt) ? null : verify;
        } catch (JWTVerificationException jwtVerificationException) {
            return null;
        }
    }

    /**
     * 获取token中的信息
     *
     * @author Silvery
     * @since 2023/8/18 14:43
     * @param jwt token
     * @return LoginUser
     */
    public LoginUser toUser(DecodedJWT jwt) {
        Map<String, Claim> claims = jwt.getClaims();
        String user = claims.get("user").asString();
        return JSONObject.parseObject(user, LoginUser.class);
    }

    /**
     * 在请求头信息中获取token
     *
     * @author Silvery
     * @since 2023/8/18 14:43
     * @param authToken 请求头信息
     * @return String
     */
    private String convertToken(String authToken) {
        if (!StringUtils.hasText(authToken) || !authToken.startsWith("Bearer "))
            return null;
        return authToken.substring(TOKEN_SITE);
    }

    /**
     * token过期时间
     *
     * @author Silvery
     * @since 2023/8/18 14:43
     * @return Date
     */
    private Date expireTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 7 * 24);
        return calendar.getTime();
    }
}
