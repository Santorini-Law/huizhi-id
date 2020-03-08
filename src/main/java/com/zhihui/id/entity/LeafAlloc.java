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

    /**
     * 业务标签
     */
    private String bizTag;

    /**
     * max id
     */
    private Long maxId;

    /**
     * 步长
     */
    private Integer step;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
