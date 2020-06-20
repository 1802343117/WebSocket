package com.soft1851.devoted.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class TMessageLabel {
    private Integer id;
    private String labelId;
    private String labelContent;
    private LocalDateTime createTime;

    public TMessageLabel() {
    }

    public TMessageLabel(Integer id, String labelId, String labelContent, LocalDateTime createTime) {
        this.id = id;
        this.labelId = labelId;
        this.labelContent = labelContent;
        this.createTime = createTime;
    }
}
