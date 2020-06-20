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
 * @author Tull
 * @since 2020-06-09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TRole {


    private Integer tbRoleId;


    private Boolean deleteFlag;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;


    private String roleDecoration;


    private String roleId;


    private String roleName;


}
