package com.soft1851.devoted.domain.dto;

import lombok.*;

/**
 * @author 12559
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private Integer userId;
    private String account;
    private String password;
    private String userPath;
}
