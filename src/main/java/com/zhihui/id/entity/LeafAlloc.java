package com.zhihui.id.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * leaf alloc
 *
 * @author LDZ
 * @date 2020-03-08 11:27
 */
@Data
public class LeafAlloc {
    private String bizTag;
    private Long maxId;
    private Integer step;
    private String remark;
    private LocalDateTime updateTime;
}
