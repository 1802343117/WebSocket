package com.soft1851.devoted.controller;


import com.soft1851.devoted.common.ResponseResult;
import com.soft1851.devoted.domain.entity.TUser;
import com.soft1851.devoted.service.impl.TUserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Tull
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/api/user")
public class TUserController {
    @Resource
    private TUserServiceImpl tUserServiceImpl;

//    //登录
//    @PostMapping("/login")
//    public ResponseResult userLogin(LoginDto loginDto) {
//        return tUserServiceImpl.userLogin(loginDto);
//    }

    //查所有用户
    @GetMapping("/selectUser")
    public ResponseResult selectUser() {
        return ResponseResult.success(tUserServiceImpl.selectUser());
    }

    //添加用户
    @PostMapping("/addUser")
    public void addUser(TUser tUser){
        tUserServiceImpl.addUser(tUser);
    }

    //根据指定id删除用户
    @DeleteMapping("/deleteUser")
    public ResponseResult deleteUser(Integer id){
        return ResponseResult.success(tUserServiceImpl.deleteByIdUser(id));
    }

    //根据指定id修改用户
    @PutMapping("/updateUser")
    public void updateUser(TUser tUser){
       tUserServiceImpl.updateUser(tUser);
    }

    /**
     * 通过ID查询用户信息
     * @param userId
     * @return
     */
    @GetMapping("selectById")
    public TUser selectById(@Param("userId") Integer userId) {
        return tUserServiceImpl.selectById(userId);
    }

}
