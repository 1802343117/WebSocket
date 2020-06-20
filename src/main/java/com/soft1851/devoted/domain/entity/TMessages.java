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
public class TMessages {

    private Integer mId;


    private Boolean deleteFlag;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;

    private String mContent;


    private String mFromUserid;


    private String roleId;

    private LocalDateTime mTime;

    private String mToUserid;


}
