package com.soft1851.devoted.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.soft1851.devoted.domain.dto.LoginDto;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service("TokenService")
public class TokenService {
    public String getToken(LoginDto user) throws UnsupportedEncodingException {
        String token="";
        token= JWT.create().withAudience(user.getAccount())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
