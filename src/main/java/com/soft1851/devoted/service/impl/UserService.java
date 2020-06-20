package com.soft1851.devoted.service.impl;


import com.soft1851.devoted.domain.dto.LoginDto;
import com.soft1851.devoted.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jinbin
 * @date 2018-07-08 20:52
 */
@Service("UserService")
public class UserService {
    @Resource
    TUserMapper tuserMapper;
    public LoginDto findByUsername(LoginDto user){
        return tuserMapper.findByAccount(user.getAccount());
    }
    public LoginDto findUserById(String userId) {
        return tuserMapper.findUserById(userId);
    }

}
