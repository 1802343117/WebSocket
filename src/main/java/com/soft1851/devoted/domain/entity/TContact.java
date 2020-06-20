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
public class TContact {

    private static final long serialVersionUID = 1L;


    private Integer userId;


    private Integer contactId;


    private Boolean deleteFlag;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;


    private String remarks;


}
