package com.soft1851.devoted.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TLabel {

    private static final long serialVersionUID = 1L;

    private Integer tbId;

    private String labelContent;

    private LocalDateTime gmtCreate;


    private LocalDateTime gmtModified;

    private Boolean deleteFlag;
}
