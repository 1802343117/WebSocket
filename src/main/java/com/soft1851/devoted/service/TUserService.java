package com.soft1851.devoted.service;

import com.soft1851.devoted.domain.dto.LoginDto;
import com.soft1851.devoted.domain.entity.TUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
public interface TUserService {

    /**
     * 用户登录
     * @param loginDto
     * @return LoginDto
     */
    boolean userLogin(LoginDto loginDto);

    List<TUser> selectUser();

    void addUser(TUser tUser);

    Integer deleteByIdUser(Integer id);

    void updateUser(TUser tUser);

    /**
     * 根据ID查询用户信息
     * @param userId
     * @return
     */
    TUser selectById(Integer userId);
}
