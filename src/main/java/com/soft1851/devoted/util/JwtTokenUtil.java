package com.soft1851.devoted.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
public class JwtTokenUtil {
    /**
     * 加密
     *
     * @param adminId
     * @param roles
     * @param expiresAt
     * @return String
     */
    public static String getToken(final String adminId, final String roles, Date expiresAt) {
        String token = null;
        try {
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("adminId", adminId)
                    .withClaim("roles", roles)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥
                    .sign(Algorithm.HMAC256("mySecret"));
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码格式");
        }
        return token;
    }

    /**
     * 解密
     *
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT deToken(final String token) {
        DecodedJWT jwt;
        JWTVerifier verifier = null;
        try {
            verifier = JWT.require(Algorithm.HMAC256("mySecret"))
                    .withIssuer("auth0")
                    .build();
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码格式");
        }
        assert verifier != null;
        jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取adminId
     *
     * @param token
     * @return String
     */
    public static String getAdminId(String token) {
        return deToken(token).getClaim("adminId").asString();
    }

    /**
     * 获取roles
     *
     * @param token
     * @return String
     */
    public static String getRoles(String token) {
        return deToken(token).getClaim("roles").asString();
    }

    /**
     * 验证是否过期
     *
     * @param token
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        return deToken(token).getExpiresAt().before(new Date());
    }

}
