package com.soft1851.devoted.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.devoted.domain.dto.LoginDto;
import com.soft1851.devoted.domain.dto.UserDto;
import com.soft1851.devoted.mapper.TUserMapper;
import com.soft1851.devoted.mapper.UserDtoMapper;
import com.soft1851.devoted.service.TMenuService;
import com.soft1851.devoted.service.TUserService;
import com.soft1851.devoted.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("api")
public class LoginController {

    @Resource
    private TUserService tUserService;

    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private UserDtoMapper userDtoMapper;

    @Resource
    private TMenuService tMenuService;

    /**
     * 登录
     * @param loginDto
     * @return String
     */
    @PostMapping("/login")
    public Map login(@RequestBody LoginDto loginDto) {
        Map<String, Object> map = new TreeMap<>();
        // 判断登录结果
        boolean isLogin = tUserService.userLogin(loginDto);
        if ( isLogin ) {
            // 登录成功, 先获取用户的角色ID,然后通过ID得到相应信息
            LoginDto login = tUserMapper.userLogin(loginDto.getAccount());
            UserDto userDto = userDtoMapper.userJoint(login.getUserId());
            Map<String, Object> tMenu = tMenuService.selectById(userDto.getMenuId());
            // 生成token，有效时间10分钟
            String token = JwtTokenUtil.getToken(Integer.toString(login.getUserId()), JSONObject.toJSONString(userDto), new Date(System.currentTimeMillis() + 600L * 1000L));
            System.out.println(token);

            map.put("userDto", userDto);
            map.put("tMenu", tMenu);
            map.put("token", token);
        } else {
            map.put("msg", "登录失败");
        }
        return map;
    }
}
