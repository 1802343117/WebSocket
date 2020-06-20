package com.soft1851.devoted.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author hjl
 * @since 2020-06-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TUser {
    private Integer userId;
    private String account;
    private String avatar;
    private Boolean deleteFlag;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String password;

    private Integer roleId;

    private String salt;

    private Boolean status;

    private String userGender;

    private String userName;

    private String userPath;

    private String userPhone;
}
