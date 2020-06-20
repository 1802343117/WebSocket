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
public class TComment {

    private Integer tbId;

    private Integer userId;


    private String content;


    private Boolean deleteFlag;


    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;
}
