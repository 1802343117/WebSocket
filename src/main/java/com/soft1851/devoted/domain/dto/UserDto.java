package com.soft1851.devoted.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer userId;
    private String account;
    private String avatar;
    private Boolean deleteFlag;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private String password;
    private String roleId;
    private String salt;
    private Boolean status;
    private String userGender;
    private String userName;
    private String userPath;
    private String userPhone;
    private String roleName;
    private String roleDecoration;
    private Integer menuId;
//    private  String menuName;
//    private String path;


}
