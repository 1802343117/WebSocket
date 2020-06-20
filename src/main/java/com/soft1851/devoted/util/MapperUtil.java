package com.soft1851.devoted.util;

import com.soft1851.devoted.domain.entity.TUser;
import com.soft1851.devoted.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author 12559
 */
@Component
public class MapperUtil {

    @Autowired
    private TUserMapper tUserMapper;

    public static MapperUtil mapperUtil;

    @PostConstruct
    public void init() {
        mapperUtil = this;
        mapperUtil.tUserMapper = this.tUserMapper;
    }

    /**
     * 通过用户ID查看用户信息
     * @param userId
     * @return
     */
    public static TUser selectById(Integer userId) {
        return mapperUtil.tUserMapper.selectById(userId);
    }

    /**
     * 通过用户ID修改用户信息
     * @param tUser
     */
    public static void updateUserPath(TUser tUser) {
        mapperUtil.tUserMapper.updateUserPath(tUser);
    }

    /**
     * 固定查询
     * 查看用户表中
     * 角色为：服务人员
     * 用户状态为：未接入
     * 登录情况不为：null
     * @return TUser
     */
    public static List<TUser> selectRsu() {
        return mapperUtil.tUserMapper.selectRsu();
    }
}
