package com.soft1851.devoted.service;

import com.soft1851.devoted.domain.dto.LoginDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TUserServiceTest {

    @Resource
    private TUserService tUserService;

    @Test
    void userLogin() {
        LoginDto loginDto = new LoginDto();
        loginDto.setAccount("111");
        loginDto.setPassword("123456");
        loginDto.setUserPath("0");
        tUserService.userLogin(loginDto);
    }
}