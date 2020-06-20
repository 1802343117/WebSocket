package com.soft1851.devoted.mapper;

import com.soft1851.devoted.domain.entity.TUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
class TUserMapperTest {
    @Resource
    private TUserMapper tUserMapper;
    LocalDateTime today = LocalDateTime.now();

    @Test
    void addUser() {
        TUser tUser = new TUser();
        tUser.setUserId(2);
        tUser.setAccount("1");
        tUser.setAvatar("https://upload.jianshu.io/users/upload_avatars/14261279/e625c28b-efac-4822-90c3-7011042192b3?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240");
        tUser.setDeleteFlag(true);
        tUser.setGmtCreate(today);
        tUser.setGmtModified(today);
        tUser.setPassword("2");
        tUser.setRoleId(1);
        tUser.setSalt("1");
        tUser.setStatus(true);
        tUser.setUserGender("1");
        tUser.setUserName("1");
        tUser.setUserPath("1");
        tUser.setUserPhone("1");
        tUserMapper.addUser(tUser);
    }

    @Test
    void selectUser() {
        System.out.println(tUserMapper.selectUser());
    }

    @Test
    void deleteByIdUser() {
        tUserMapper.deleteByIdUser(2);
    }

    @Test
    void updateUser() {
        TUser tUser = new TUser();
        tUser.setUserId(3);
        tUser.setAccount("2");
        tUser.setAvatar("https://upload.jianshu.io/users/upload_avatars/14261279/e625c28b-efac-4822-90c3-7011042192b3?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240");
        tUser.setDeleteFlag(true);
        tUser.setGmtCreate(today);
        tUser.setGmtModified(today);
        tUser.setPassword("2");
        tUser.setSalt("1");
        tUser.setStatus(true);
        tUser.setUserGender("1");
        tUser.setUserName("1");
        tUser.setUserPath("1");
        tUser.setUserPhone("1156165165");
        tUserMapper.updateUser(tUser);
    }

    @Test
    void selectById() {
        System.out.println(tUserMapper.selectById(1));
    }

    @Test
    void updateUserPath() {
        TUser tUser = new TUser();
        tUser.setUserId(3);
        tUser.setStatus(false);
        tUser.setUserPath("0");
        tUserMapper.updateUserPath(tUser);
    }

    /**
     * 固定查询
     * @return TUser
     */
    @Test
    void selectRsu() {
        int roleId = 2;
        boolean status = false;
        String userPath = "0";
        System.out.println(tUserMapper.selectRsu().toString());
    }

    /**
     * 通过账号查询
     */
    @Test
    void userLogin() {
        System.out.println(tUserMapper.userLogin("111"));
    }
}